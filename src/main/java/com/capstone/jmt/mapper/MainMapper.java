package com.capstone.jmt.mapper;

import com.capstone.jmt.data.MessageJson;
import com.capstone.jmt.data.RefGradeLevel;
import com.capstone.jmt.data.TapLog;
import com.capstone.jmt.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jabito on 08/08/2017.
 */
public interface MainMapper {
    User getUserByUsername(@Param("username") String username);

    Student getStudent(@Param("id") String studentId);

    void updateStudent(@Param("student") Student student);

    void addStudent(@Param("student")Student student);

    void deleteStudentById(@Param("id") String id);

    void postAnnouncement(@Param("mj") MessageJson mj);

    TapLog getLastTapDetails(@Param("rfid") String rfid);

    void addUser(@Param("user") User user);

    TapLog getLastTapDetailsByStudentId(@Param("studentId") String studentId);

    List<TapLog> getTapListDetailsByStudentId(@Param("studentId") String studentId);

    List<RefGradeLevel> getGradeLevelList();

    void addTeacher(@Param("guidance") Guidance guidance);

    Guidance getGuidance(@Param("id") String id);

    Parent getParent(@Param("id") String id);

    EmergencyContact getEmergencyContact(@Param("id") String id);

    User getUserById(@Param("id") String id);

    int getLastId(@Param("id") int id);

    void incrementId(@Param("id") int id);
}
