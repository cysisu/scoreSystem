package cn.wxf.score.dao;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    List<Student> getStudent(@Param("studentId")String studentId, @Param("password")String password);
    List<Score> getScores(@Param("studentId")String studentId);
    List<Score> findScores(Score score);
    int updateStudentInfo(Student student);
    List<Student> getStudentById(@Param("studentId")String studentId);
    int insertStudent(@Param("studentId")String studentId, @Param("password")String password);
}
