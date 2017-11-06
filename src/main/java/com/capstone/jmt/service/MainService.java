package com.capstone.jmt.service;

import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.mapper.MainMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jabito on 08/08/2017.
 */
@Service("mainService")
public class MainService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MainMapper mainMapper;

    public HashMap<String, Object> loginUser(String username, String password) {
        HashMap<String, Object> response = new HashMap<>();

        User user = mainMapper.getUserByUsername(username);
        response.put("user", user);
        if(null == user){
            response.put("responseCode", HttpStatus.NOT_FOUND);
            response.put("responseDesc", "Username does not exists.");
        }else{
            if(passwordEncoder.matches(password, user.getPassword())){
                response.put("responseCode", HttpStatus.OK);
                response.put("responseDesc", "Login Successful.");
            }else{
                response.put("responseCode", HttpStatus.UNAUTHORIZED);
                response.put("responseDesc", "Password incorrect.");
            }
        }
        return response;
    }

    public HashMap<String, Object> getStudent(String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        Student student = mainMapper.getStudent(studentId);
        response.put("student", student);
        if(null == student){
            response.put("responseCode", HttpStatus.NOT_FOUND);
            response.put("responseDesc", "Student does not exists.");
        }else{
            response.put("responseCode", HttpStatus.OK);
            response.put("responseDesc", "Student Found.");
        }

        return response;
    }

    public HashMap<String, Object> getLastTap(String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        //TODO Last Tap Log of Student
        return response;
    }
}
