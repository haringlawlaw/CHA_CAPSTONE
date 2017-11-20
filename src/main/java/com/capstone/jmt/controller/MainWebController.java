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

import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/app/")

public class MainWebController {


    @Autowired
    MainService mainService;


    @ModelAttribute("appUSer")
    public User getShopUser() {
        return new User();
    }

    @RequestMapping(value="loginUser", method = RequestMethod.POST)
    public String loginUser(User user, Model model){

        HashMap<String, Object> returnJson = mainService.loginUser(user.getUsername(),user.getPassword());
        User returnedUser = (User) returnJson.get("User");

        return "redirect:/homepage/";
    }

}
