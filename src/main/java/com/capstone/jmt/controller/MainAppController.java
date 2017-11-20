package com.capstone.jmt.controller;

import com.capstone.jmt.data.AddUserJson;
import com.capstone.jmt.data.MessageJson;
import com.capstone.jmt.data.ShopLogin;
import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by Jabito on 08/08/2017.
 */
@Controller
@RequestMapping(value="/app/")
@SessionAttributes("appUSer")
public class MainAppController {

    @Autowired
    private MainService mainService;



    @RequestMapping(value="processRfidTap", method = RequestMethod.POST)
    public ResponseEntity<?> processRfidTap(@RequestParam("rfid") String rfid){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.processRfidTap(rfid));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

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

    @RequestMapping(value="getTapLogOfStudent", method = RequestMethod.GET)
    public ResponseEntity<?> getTapLogOfStudent(@RequestParam String studentId){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getTapLogOfStudent(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="getLastTapEntry", method = RequestMethod.GET)
    public ResponseEntity<?> getLastTapEntry(@RequestParam String studentId){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getLastTapEntry(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "editStudentInfo", method = RequestMethod.POST)
    public ResponseEntity<?> editStudentInfo(@RequestParam Student student){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.updateStudentInfo(student));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addOrDeleteStudent", method = RequestMethod.POST)
    public ResponseEntity<?> addOrDeleteStudent(@RequestParam Student student, @RequestParam String appUsername, @RequestParam String command){
        HashMap<String, Object> response = new HashMap<>();
        User teacher = mainService.getUser(appUsername);
        if(teacher.getUserTypeId() == 0){
            if(command.equalsIgnoreCase("add"))
                response.putAll(mainService.addStudent(student));
            else if(command.equalsIgnoreCase("delete"))
                response.putAll(mainService.deleteStudentById(student.getId()));
        }else{
            response.put("responseCode", 404);
            response.put("respnoseDesc", "Unauthorized request. User does not have admin status.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody AddUserJson user){
        HashMap<String, Object> response = new HashMap<>();
        User admin = mainService.getUser(user.getAppUsername());
        if(null != admin) {
            User teacher = mainService.getUser(user.getUsername());
            if (null != teacher) {
                response.put("responseCode", 201);
                response.put("responseDesc", "Username already taken.");
            } else {
                response.put("responseCode", 200);
                response.put("responseDesc", "Successfully created User.");
                mainService.addUser(user);
            }
        }else{
            response.put("responseCode", 404);
            response.put("responseDesc", "Username not found.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value="postAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<?> postAnnouncement(@RequestParam MessageJson mj){
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.postAnnouncement(mj));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
