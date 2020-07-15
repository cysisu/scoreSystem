package cn.wxf.score.dao;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeacher(@Param("teacherId")String teacherId, @Param("password")String password);
    int insertScore(Score score);
    List<Score> getScores(@Param("teacherId")String teacherId);
    List<Score> findScores(Score score);
    int deleteScore(Score score);
    int updateTeacherInfo(Teacher teacher);
    int updateScore(Score score);
    List<Teacher> getTeacherById(@Param("teacherId")String teacherId);
    int insertTeacher(@Param("teacherId")String teacherId, @Param("password")String password);
}
