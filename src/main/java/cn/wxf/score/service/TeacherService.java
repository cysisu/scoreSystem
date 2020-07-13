package cn.wxf.score.service;

import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacher(String username, String password);
}
