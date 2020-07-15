package cn.wxf.score.service.impl;

import cn.wxf.score.dao.StudentDao;
import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import cn.wxf.score.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudent(String studentId, String password){
        return studentDao.getStudent(studentId,password);
    }

    public List<Score> getScores(@Param("studentId")String studentId){
        return studentDao.getScores(studentId);
    }
    public List<Score> findScores(Score score){
        return studentDao.findScores(score);
    }
    public int updateStudentInfo(Student student){
        return studentDao.updateStudentInfo(student);
    }

    public List<Student> getStudent(String studentId){
        return studentDao.getStudentById(studentId);
    }

    public int insertStudent(String studentId, String password){
        return studentDao.insertStudent(studentId,password);
    }

}
