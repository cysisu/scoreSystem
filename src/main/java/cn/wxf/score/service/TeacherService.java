package cn.wxf.score.service;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacher(String username, String password);
    int insertScore(Score score);
    List<Score> getScores(String teacherId);
    List<Score> findScores(Score score);
    int deleteScore(Score score);
    int updateTeacherInfo(Teacher teacher);
    int updateScore(Score score);
    List<Teacher> getTeacher(String teacherId);
    int insertTeacher(String teacherId, String password);
}
