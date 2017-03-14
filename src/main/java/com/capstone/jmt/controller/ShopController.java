package com.capstone.jmt.controller;

import com.capstone.jmt.data.*;
import com.capstone.jmt.service.OrderService;
import com.capstone.jmt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Jabito on 24/02/2017.
 */
@Controller
@RequestMapping(value="/")
@SessionAttributes("shopUser")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderService orderService;
    /*
    List of all GET Requests
     */
    @ModelAttribute("shopUser")
    public ShopLogin getShopUser(){
        return new ShopLogin();
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginShopUser(@RequestParam(value="error", required = false) String error, HttpServletRequest request,
                                Model model){
        if(null != error){
            if(error.equals("1"))
                model.addAttribute("param.error", true);
            else if(error.equals("2"))
                model.addAttribute("param.logout", true);
        }
        model.addAttribute("user", new ShopLogin());

        return "login";
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String showDashboard(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";

        model.addAttribute("totalSales", "P " + shopService.getTotalSales(shopUser.getStaffOf()));
        model.addAttribute("saleCount", shopService.getSalesCount(shopUser.getStaffOf()));
        model.addAttribute("rating", shopService.getShopRating(shopUser.getStaffOf()));

        return "dashboard";
    }

    @RequestMapping(value="/rating", method = RequestMethod.GET)
    public String shopRating(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";


        return "rating";
    }

    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String loginShopUser3(Model model){



        return "main";
    }

    @RequestMapping(value="/sales", method = RequestMethod.GET)
    public String showSales(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";

            model.addAttribute("orders", orderService.getOrdersByShopId(shopUser.getStaffOf()));

            return "sales";
    }

    @RequestMapping(value="/transactions", method = RequestMethod.GET)
    public String showTransactions(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";

        return "transactions";
    }

    @RequestMapping(value="/inventory", method = RequestMethod.GET)
    public String shopInventory(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";


        return "inventory";
    }

    @RequestMapping(value="/bottlesales", method = RequestMethod.GET)
    public String showBottleSales(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";


        return "bottlesales";
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public String shopProfile(@ModelAttribute("shopUser") ShopLogin shopUser, Model model){
        if(shopUser.getId() == null)
            return "redirect:/login";

        model.addAttribute("shop", shopService.getShopInfoById(shopUser.getStaffOf()));
        return "profile";
    }
    /*
    List of all POST Requests
     */
    @RequestMapping(value="loginUser", method = RequestMethod.POST)
    public String loginUser(ShopLogin shop, Model model){
        ShopLogin user = shopService.validateUser(shop);
        if(null != user){
            model.addAttribute("shopUser", user);
            return "redirect:/dashboard/";
        }else{
            return "redirect:/login/?error=" + "1";
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String logOutUser(@ModelAttribute("shopUser") ShopLogin shopUser, HttpServletRequest request, SessionStatus session){
        session.setComplete();

        return "login";
    }

/*
    @RequestMapping(value="/shop", method=RequestMethod.GET)
    public String getShopLoginById(@RequestBody ShopLogin shopUser, Model model){
        HashMap<String, Object> response = new HashMap<>();
        ShopLogin shop = shopService.getShopLoginById(shopUser.getId());
        response.put("shop", shop);
        return "main";
    }

    @RequestMapping(value="/shop/info", method=RequestMethod.GET)
    public ResponseEntity<?> getShopInfoById(@RequestParam("id") String id){
        HashMap<String, Object> response = new HashMap<>();
        ShopInfo shop = shopService.getShopInfoById(id);
        response.put("shop", shop);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/shop/location", method=RequestMethod.GET)
    public ResponseEntity<?> getShopLocationById(@RequestParam("id") String id){
        HashMap<String, Object> response = new HashMap<>();
        ShopLocation shop = shopService.getShopLocationById(id);
        response.put("shop", shop);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/shop/watertypes", method= RequestMethod.GET)
    public ResponseEntity<?> getWaterTypesOfferedById(@RequestParam("id") String id){
        HashMap<String, Object> response = new HashMap<>();
        WaterTypesOffered shop = shopService.getWaterTypesOfferedById(id);
        response.put("shop", shop);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/shop/containers", method= RequestMethod.GET)
    public ResponseEntity<?> getOrderContainersById(@RequestParam("id") String id){
        HashMap<String, Object> response = new HashMap<>();
        ContainersOffered shop = shopService.getContainersOfferedById(id);
        response.put("shop", shop);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addOrUpdateShopInfo", method=RequestMethod.POST)
    public ResponseEntity<?> addOrUpdateShopInfo(@RequestBody ShopInfo shop){
        HashMap<String, Object> response = new HashMap<>();

        ShopInfo existingShopInfo = shopService.getShopInfoById(shop.getId());

        if(null == existingShopInfo){
            shopService.addShopInfo(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Added Shop Info.");
        }else{
            shopService.updateShopInfo(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("resonseDesc", "Successfully Updated Shop Info.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addOrUpdateShopLogin", method=RequestMethod.POST)
    public ResponseEntity<?> addOrUpdateShopLogin(@RequestBody ShopLogin shop){
        HashMap<String, Object> response = new HashMap<>();

        ShopLogin existingShopLogin = shopService.getShopLoginById(shop.getId());
        if(null == existingShopLogin){
            shopService.addShopLogin(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Added Shop Login.");
        }else{
            shopService.updateShopLogin(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Updated Shop Login.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addOrUpdateShopLocation", method=RequestMethod.POST)
    public ResponseEntity<?> addOrUpdateShopLocation(@RequestBody ShopLocation shop){
        HashMap<String, Object> response = new HashMap<>();

        ShopLocation existingShopLocation = shopService.getShopLocationById(shop.getId());
        if(null == existingShopLocation){
            shopService.addShopLocation(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Added Shop Location.");
        }else{
            shopService.updateShopLocation(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Updated Shop Location.");
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(value="addOrUpdateWaterTypesOffered", method = RequestMethod.POST)
    public ResponseEntity<?> addOrUpdateWaterTypesOffered(@RequestBody WaterTypesOffered shop){
        HashMap<String, Object> response = new HashMap<>();

        WaterTypesOffered existingWaterTypesOffered = shopService.getWaterTypesOfferedById(shop.getId());
        if(null == existingWaterTypesOffered){
            shopService.addWaterTypesOffered(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("reponseDesc", "Successfully Added Water Types Offered.");
        }else{
            shopService.updateWaterTypesOffered(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Updated Water Types Offered.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addOrUpdateContainersOffered", method=RequestMethod.POST)
    public ResponseEntity<?> addOrUpdateContainersOffered(@RequestBody ContainersOffered shop){
        HashMap<String, Object> response = new HashMap<>();

        ContainersOffered existingContainersOffered = shopService.getContainersOfferedById(shop.getId());
        if(null == existingContainersOffered){
            shopService.addContainersOffered(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Added Containers Offered.");
        }else{
            shopService.updateContainersOffered(shop);
            response.put("shop", shop);
            response.put("id", shop.getId());
            response.put("responseCode", 200);
            response.put("responseDesc", "Successfully Updated Containers Offered.");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
}
