package com.capstone.jmt.controller;

import com.capstone.jmt.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/app/")
public class MainAppController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value="loginUser", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.loginUser(username, password));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="getStudent", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@RequestParam String studentId){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getStudent(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="getLastTap", method = RequestMethod.GET)
    public ResponseEntity<?> getLastTap(@RequestParam String studentId){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getLastTap(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
