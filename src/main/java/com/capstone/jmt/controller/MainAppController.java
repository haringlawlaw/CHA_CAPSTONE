package com.capstone.jmt.controller;

import com.capstone.jmt.data.AddGuidanceJson;
import com.capstone.jmt.data.AddUserJson;
import com.capstone.jmt.data.MessageJson;
import com.capstone.jmt.entity.Guidance;
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
@RequestMapping(value = "/app/")
@SessionAttributes("appUSer")
public class MainAppController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "processRfidTap", method = RequestMethod.POST)
    public ResponseEntity<?> processRfidTap(@RequestParam("rfid") String rfid) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.processRfidTap(rfid));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.loginUser(username, password));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@RequestParam String id) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getUserById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getStudent", method = RequestMethod.GET)
    public ResponseEntity<?> getStudent(@RequestParam String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getStudent(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getGuidance", method = RequestMethod.GET)
    public ResponseEntity<?> getGuidance(@RequestParam String id) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getGuidance(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getParent", method = RequestMethod.GET)
    public ResponseEntity<?> getParent(@RequestParam String id) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getParent(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getEmergencyContact", method = RequestMethod.GET)
    public ResponseEntity<?> getEmergencyContact(@RequestParam String id) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getEmergencyContact(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getTapLogOfStudent", method = RequestMethod.GET)
    public ResponseEntity<?> getTapLogOfStudent(@RequestParam String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getTapLogOfStudent(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "getLastTapEntry", method = RequestMethod.GET)
    public ResponseEntity<?> getLastTapEntry(@RequestParam String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.getLastTapEntry(studentId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "editStudentInfo", method = RequestMethod.POST)
    public ResponseEntity<?> editStudentInfo(@RequestParam Student student) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.updateStudentInfo(student));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "addGuidance", method = RequestMethod.POST)
    public ResponseEntity<?> addGuidance(@RequestBody AddGuidanceJson teacherJson) {
        HashMap<String, Object> response = new HashMap<>();
        User user = mainService.getUser(teacherJson.getAppUsername());
        if (user.getUserTypeId() == 0) {
            Guidance guidance = new Guidance(teacherJson);
            response.putAll(mainService.addGuidance(guidance));
        } else {
            response.put("responseCode", 404);
            response.put("respnoseDesc", "Unauthorized request. User does not have admin status.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestParam Student student, @RequestParam String appUsername) {
        HashMap<String, Object> response = new HashMap<>();
        User teacher = mainService.getUser(appUsername);
        if (teacher.getUserTypeId() == 0) {
            response.putAll(mainService.addStudent(student));
        } else {
            response.put("responseCode", 404);
            response.put("respnoseDesc", "Unauthorized request. User does not have admin status.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteStudent", method = RequestMethod.POST)
    public ResponseEntity<?> deleteStudent(@RequestParam String studentId, @RequestParam String appUsername) {
        HashMap<String, Object> response = new HashMap<>();
        User teacher = mainService.getUser(appUsername);
        if (teacher.getUserTypeId() == 0) {
            response.putAll(mainService.deleteStudentById(studentId));
        } else {
            response.put("responseCode", 404);
            response.put("respnoseDesc", "Unauthorized request. User does not have admin status.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody AddUserJson user) {
        HashMap<String, Object> response = new HashMap<>();
        User admin = mainService.getUser(user.getAppUsername());
        System.out.println(user.getAppUsername());
        if (null != admin || user.getAppUsername().equalsIgnoreCase("admin")) {
                if(user.getAppUsername().equalsIgnoreCase("admin") || 0 == admin.getUserTypeId()) {
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
                response.put("responseCode", HttpStatus.UNAUTHORIZED);
                response.put("responseDesc", "Unauthorized user.");
            }
        } else {
            response.put("responseCode", 404);
            response.put("responseDesc", "Admin user ID not found.");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "postAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<?> postAnnouncement(@RequestBody MessageJson mj) {
        HashMap<String, Object> response = new HashMap<>();
        response.putAll(mainService.postAnnouncement(mj));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @RequestMapping(value = "getAnnouncements", method = RequestMethod.GET)
//    public ResponseEntity<?> getAnnouncements(@RequestParam String)
}
