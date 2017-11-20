package com.capstone.jmt.controller;

import com.capstone.jmt.entity.User;
import com.capstone.jmt.service.MainService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/app/")

public class MainWebController {


    @Autowired
    MainService mainService;



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

}
