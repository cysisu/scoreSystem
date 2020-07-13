package cn.wxf.score.service.impl;

import cn.wxf.score.dao.TeacherDao;
import cn.wxf.score.entity.Student;
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
}
