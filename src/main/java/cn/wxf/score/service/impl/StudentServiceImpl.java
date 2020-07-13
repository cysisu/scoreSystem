package cn.wxf.score.service.impl;

import cn.wxf.score.dao.StudentDao;
import cn.wxf.score.entity.Student;
import cn.wxf.score.service.StudentService;
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

}
