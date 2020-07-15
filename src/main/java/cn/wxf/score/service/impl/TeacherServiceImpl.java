package cn.wxf.score.service.impl;

import cn.wxf.score.dao.TeacherDao;
import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Teacher;
import cn.wxf.score.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getTeacher(String teacherId, String password){
        return teacherDao.getTeacher(teacherId,password);
    }

    public int insertScore(Score score){
        return teacherDao.insertScore(score);
    }

    public List<Score> getScores(String teacherId){
        return teacherDao.getScores(teacherId);
    }
    public List<Score> findScores(Score score){
        return teacherDao.findScores(score);
    }

    public int deleteScore(Score score){
        return teacherDao.deleteScore(score);
    }
    public int updateTeacherInfo(Teacher teacher){
        return teacherDao.updateTeacherInfo(teacher);
    }
    public int updateScore(Score score){
        return teacherDao.updateScore(score);
    }
    public List<Teacher> getTeacher(String teacherId){
        return teacherDao.getTeacherById(teacherId);
    }
    public int insertTeacher(String teacherId, String password){
        return teacherDao.insertTeacher(teacherId,password);
    }
}
