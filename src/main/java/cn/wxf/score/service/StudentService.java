package cn.wxf.score.service;

import cn.wxf.score.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent(String studentId, String password);
}
