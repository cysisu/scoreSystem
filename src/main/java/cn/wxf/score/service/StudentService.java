package cn.wxf.score.service;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> getStudent(String studentId, String password);
    List<Score> getScores(@Param("studentId")String studentId);
    List<Score> findScores(Score score);
    int updateStudentInfo(Student student);
    List<Student> getStudent(String studentId);
    int insertStudent(String studentId, String password);
}
