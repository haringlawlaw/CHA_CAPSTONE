package com.capstone.jmt.controller;

import com.capstone.jmt.data.AddUserJson;
import com.capstone.jmt.data.ShopLogin;
import com.capstone.jmt.entity.Guidance;
import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.service.MainService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/")
@SessionAttributes("appUser")
public class MainWebController {


    @Autowired
    MainService mainService;

    @ModelAttribute("appUSer")
    public User getShopUser() {
        return new User();
    }

    @ModelAttribute("student")
    public Student getStudent() {
        return new Student();
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
    public String loginWebUser(@ModelAttribute("appUser") User user, org.springframework.ui.Model model){


        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("PASSWORD: " + user.getPassword());

        HashMap<String, Object> returnJson = mainService.loginUser(user.getUsername(),user.getPassword());
        User returnedUser = (User) returnJson.get("User");
        if(null == returnedUser){
            System.out.println("Null");
        }

        System.out.println("RETURNED USER: " + returnedUser.getUsername());
        model.addAttribute("User", returnedUser);

        return "redirect:/homepage";
    }


    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String showDashboard(@ModelAttribute("appUser") User user, org.springframework.ui.Model model) {
        System.out.println("HOMEPAGE: " + user.getUsername());
       if(null != user.getUsername()) {
           model.addAttribute("User", user);
           return "dashboard";
       }
       return "redirect:/login";
    }


    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public String shopAddStudent(@Valid Student student, org.springframework.ui.Model model) {

        model.addAttribute("student", new Student());

        return "addStudent";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@Valid Student student , BindingResult bindingResult, org.springframework.ui.Model model){


        System.out.println("student first name: " + student.getFirstName());
        System.out.println("student last name: " + student.getLastName());
        try{
            student.setCreatedBy("admin123");
            mainService.addStudent(student);
            System.out.println("TRYING TO SAVE!");
            System.out.println("SUCCESS!!");
            return "redirect:/login";
        }catch (Exception e){
            e.printStackTrace();
        }

        return "addStudent";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUserData(@Valid AddUserJson newUser, org.springframework.ui.Model model){

        //TODO ADD VALIDATION OF NULL VALUES

        model.addAttribute("newUser", new User());
        return  "addUser";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String postNewUser(@Valid AddUserJson newUser, BindingResult bindingResult, org.springframework.ui.Model model){

        System.out.println("USER username: " + newUser.getUsername());
        System.out.println("USER password: " + newUser.getPassword());

        mainService.addUser(newUser);
        return "redirect:/login";
    }

    @RequestMapping(value = "/getGuidance", method = RequestMethod.GET)
    public String getGuidanceData(@Valid Guidance guidance, org.springframework.ui.Model model){

        model.addAttribute("newGuidance", new Guidance());
        return "addGuidance";
    }

    @RequestMapping(value = "/addNewGuidance", method = RequestMethod.POST)
    public String postNewGuidance(@Valid Guidance guidance, BindingResult bindingResult, org.springframework.ui.Model model){

        System.out.println("GUIDANCE FIRST NAME: " + guidance.getFirstName());
        System.out.println("GUIDANCE LAST NAME: " + guidance.getLastName());

        mainService.addGuidance(guidance);
        return "redirect:/login";

    }


}
