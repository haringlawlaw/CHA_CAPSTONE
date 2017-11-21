package com.capstone.jmt.mapper;

import com.capstone.jmt.data.MessageJson;
import com.capstone.jmt.data.RefGradeLevel;
import com.capstone.jmt.data.TapLog;
import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.Teacher;
import com.capstone.jmt.entity.User;
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

    void addTeacher(@Param("teacher") Teacher teacher);
}
