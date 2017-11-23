package com.capstone.jmt.service;

import com.capstone.jmt.data.AddUserJson;
import com.capstone.jmt.data.MessageJson;
import com.capstone.jmt.data.RefGradeLevel;
import com.capstone.jmt.data.TapLog;
import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.Teacher;
import com.capstone.jmt.entity.User;
import com.capstone.jmt.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        if (null == user) {
            response.put("responseCode", HttpStatus.NOT_FOUND);
            response.put("responseDesc", "Username does not exists.");
        } else {
            if (passwordEncoder.matches(password, user.getPassword())) {
                response.put("User", user);
                response.put("responseCode", HttpStatus.OK);
                response.put("responseDesc", "Login Successful.");
            } else {
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
        if (null == student) {
            response.put("responseCode", HttpStatus.NOT_FOUND);
            response.put("responseDesc", "Student does not exists.");
        } else {
            response.put("responseCode", HttpStatus.OK);
            response.put("responseDesc", "Student Found.");
        }

        return response;
    }

    public HashMap<String, Object> getLastTapEntry(String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        TapLog tapLog = mainMapper.getLastTapDetailsByStudentId(studentId);
        if(null != tapLog) {
            response.put("tapDetails", tapLog);
            response.put("responseCode", 200);
            response.put("responseDesc", "Last tap entry retrieved.");
        }else{
            response.put("responseCode", 404);
            response.put("responseDesc", "No logs yet.");
        }
        return response;
    }

    public HashMap<String, Object> getTapLogOfStudent(String studentId) {
        HashMap<String, Object> response = new HashMap<>();
        List<TapLog> tapLog = mainMapper.getTapListDetailsByStudentId(studentId);
        if(null != tapLog) {
            response.put("tapListDetails", tapLog);
            response.put("responseCode", 200);
            response.put("responseDesc", "Last tap entry retrieved.");
        }else{
            response.put("responseCode", 404);
            response.put("responseDesc", "No logs yet.");
        }
        return response;
    }

    public HashMap<String, Object> updateStudentInfo(Student student) {
        HashMap<String, Object> response = new HashMap<>();
        Student existingStudent = mainMapper.getStudent(student.getId());
        if (null != existingStudent) {
            mainMapper.updateStudent(student);
        } else {
            response.put("responseCode", 404);
            response.put("responseDesc", "Failed to update student.");
        }
        return response;
    }

    public HashMap<String, Object> addStudent(Student student) {
        HashMap<String, Object> response = new HashMap<>();
        student.setId(UUID.randomUUID().toString());
        mainMapper.addStudent(student);
        response.put("responseCode", 200);
        response.put("responseDesc", "Successfully added student.");
        return response;
    }

    public User getUser(String username) {
        return mainMapper.getUserByUsername(username);
    }

    public HashMap<String, Object> deleteStudentById(String id) {
        HashMap<String, Object> response = new HashMap<>();
        mainMapper.deleteStudentById(id);
        return response;
    }

    public HashMap<String, Object> postAnnouncement(MessageJson mj) {
        HashMap<String, Object> response = new HashMap<>();
        //TODO Check function.
        mainMapper.postAnnouncement(mj);
        response.put("responseCode", 200);
        response.put("responseDesc", "Announcement Posted.");

        return response;
    }

    public HashMap<String, Object> processRfidTap(String rfid) {
        HashMap<String, Object> response = new HashMap<>();
        TapLog tap = mainMapper.getLastTapDetails(rfid);
        if (null != tap) {
            response.put("tapObject", tap);
            response.put("responseCode", 200);
            response.put("responseDesc", "Success.");
        } else {
            response.put("responseCode", 404);
            response.put("responseDesc", "No tap yet or failed to retrieve.");
        }
        return response;
    }

    public void addUser(AddUserJson userJson) {
        System.out.println(UUID.randomUUID().toString());
        User user = new User();
        user.setId(UUID.randomUUID().toString().substring(0, 35));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        mainMapper.addUser(user);
    }

    public List<RefGradeLevel> getGradeLevelList(){
        return mainMapper.getGradeLevelList();
    }

    public HashMap<String, Object> addTeacher(Teacher teacher) {
        HashMap<String, Object> response = new HashMap<>();
        teacher.setId(UUID.randomUUID().toString());
        mainMapper.addTeacher(teacher);
        response.put("responseCode", 200);
        response.put("responseDesc", "Successfully Added Teacher.");
        return response;
    }
}
