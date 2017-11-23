package com.capstone.jmt.controller;

import com.capstone.jmt.data.ShopLogin;
import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.service.MainService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/")
@SessionAttributes("appUSer")
public class MainWebController {


    @Autowired
    MainService mainService;

    @ModelAttribute("appUSer")
    public User getShopUser() {
        return new User();
    }




    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginShopUser(@RequestParam(value = "error", required = false) String error, HttpServletRequest request,
                                org.springframework.ui.Model model) {
        if (null != error) {
            if (error.equals("1"))
                model.addAttribute("param.error", true);
            else if (error.equals("2"))
                model.addAttribute("param.logout", true);
        }
        model.addAttribute("appUser", getShopUser());

        return "login";
    }


    @RequestMapping(value="loginWebUser", method = RequestMethod.POST)
    public String loginWebUser(User user, org.springframework.ui.Model model){


        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("PASSWORD: " + user.getPassword());

        HashMap<String, Object> returnJson = mainService.loginUser(user.getUsername(),user.getPassword());
        User returnedUser = (User) returnJson.get("User");
        if(null == returnedUser){
            System.out.println("Null");
        }

        System.out.println("RETURNED USER: " + returnedUser.getUsername());
        model.addAttribute("user", returnedUser);

        return "redirect:/homepage/";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String shopAddStudent(Student student, org.springframework.ui.Model model) {


        model.addAttribute("student", new Student());

        return "addStudent";
    }

    @RequestMapping(value = "/attendanceLogs", method = RequestMethod.GET)
    public String showSales(@ModelAttribute("appUser") User appUser, org.springframework.ui.Model model) {
        if (appUser.getUsername() == null)
            return "redirect:/login";

//        List<OrderInfo> orders = orderService.getOrdersByShopId(shopUser.getStaffOf());
//        model.addAttribute("orders", orders);
//        model.addAttribute("username", shopUser.getUsername());
//        Double sales = 0.0;
//        for(int x=0; x<orders.size(); x++){
//            if(null!=orders.get(x).getTotalCost())
//                    sales += orders.get(x).getTotalCost();
        }
//
//        model.addAttribute("totalSales", "P " + sales.toString());
//
        return "sales";
    }

}
