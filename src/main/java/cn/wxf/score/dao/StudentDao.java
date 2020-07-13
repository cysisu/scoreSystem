package cn.wxf.score.dao;

import cn.wxf.score.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    List<Student> getStudent(@Param("studentId")String studentId, @Param("password")String password);
}
