package com.capstone.jmt.controller;

import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@SessionAttributes("appUSer")
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



    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginShopUser(@RequestParam(value = "error", required = false) String error, HttpServletRequest request,
                                Model model) {
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
    public String loginWebUser(User user, Model model){


        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("PASSWORD: " + user.getPassword());

        HashMap<String, Object> returnJson = mainService.loginUser(user.getUsername(),user.getPassword());
        User returnedUser = (User) returnJson.get("User");
        if(null == returnedUser){
            System.out.println("Null");
        }

//        System.out.println("RETURNED USER: " + returnedUser.getUsername());
//        model.addAttribute("user", returnedUser);

        return "redirect:/homepage/";
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.GET)
    public String shopAddStudent(Model model) {

        model.addAttribute("student", getStudent());
        model.addAttribute("gradeLevels", mainService.getGradeLevelList());
        return "addStudent";
    }

    @RequestMapping(value = "addNewStudent", method = RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model){

        if(null == student){
            return null;
        }

        System.out.println("STUDENT FIRST NAME: " + student.getFirstName());

        student.setCreatedBy("admin");
        mainService.addStudent(student);
        return "redirect:/addStudent";
    }

}
