package cn.wxf.score.dao;

import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeacher(@Param("teacherId")String teacherId, @Param("password")String password);
}
