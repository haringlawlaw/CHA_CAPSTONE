package com.capstone.jmt.mapper;

import com.capstone.jmt.entity.Student;
import com.capstone.jmt.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Jabito on 08/08/2017.
 */
public interface MainMapper {
    User getUserByUsername(@Param("username") String username);

    Student getStudent(@Param("id") String studentId);

    void updateStudent(@Param("student") Student student);

    void addStudent(@Param("student")Student student);

    void deleteStudentById(@Param("id") String id);
}
