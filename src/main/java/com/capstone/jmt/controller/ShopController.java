package com.capstone.jmt.controller;

import com.capstone.jmt.data.*;
import com.capstone.jmt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by Jabito on 24/02/2017.
 */
@Controller
@RequestMapping(value="/")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginShopUser(@RequestBody ShopLogin shopUser, Model model){



        return "login";
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String loginShopUser2(Model model){



        return "index";
    }

    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String loginShopUser3(Model model){



        return "main";
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String loginShopUser4(Model model){



        return "dashboard";
    }

    @RequestMapping(value="/sales", method = RequestMethod.GET)
    public String loginShopUser5(Model model){



        return "sales";
    }

    @RequestMapping(value="/transactions", method = RequestMethod.GET)
    public String loginShopUser6(Model model){



        return "transactions";
    }

    @RequestMapping(value="/inventory", method = RequestMethod.GET)
    public String loginShopUser7(Model model){



        return "inventory";
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public String loginShopUser8(Model model){



        return "profile";
    }


    @RequestMapping(value="/shop", method=RequestMethod.GET)
    public ResponseEntity<?> getShopLoginById(@RequestParam("id") String id){
        HashMap<String, Object> response = new HashMap<>();
        ShopLogin shop = shopService.getShopLoginById(id);
        response.put("shop", shop);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
    }
}
