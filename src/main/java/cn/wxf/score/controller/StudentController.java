package cn.wxf.score.controller;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import cn.wxf.score.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //返回学生查看成绩的页面
    @RequestMapping("/getScoreInfo")
    public String getScoreInfo(){
        return "jsp/student/scoreInfo";
    }

    //返回老师个人信息页面
    @RequestMapping("/studentInfo")
    public String getStudentInfo(){
        return "jsp/student/studentInfo";
    }

    //查找符合条件的成绩信息列表
    @RequestMapping(value = "/findScores")
    @ResponseBody
    public Map<String, Object> findScores(@RequestParam("teacherId") String teacherId, @RequestParam("subject") String subject , int page, int limit, HttpSession session) {
        System.out.println("学生查看过");
        String studentId=session.getAttribute("id").toString();
        Score score=new Score(studentId,teacherId,subject);
        List<Score> scores=studentService.findScores(score);
        int count = scores.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", count);
        map.put("data", scores);
        System.out.println(map);
        return map;
    }

    @RequestMapping(value="/getScores", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScores(HttpSession session){
        String studentId=session.getAttribute("id").toString();
        List<Score> scoreList = studentService.getScores(studentId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", scoreList.size());
        map.put("data", scoreList);
        return map;
    }

    //更新老师的个人信息
    @RequestMapping(value = "/updateStudentInfo" )
    @ResponseBody
    public Map<String, Object> updateStudentInfo( String studentId, String name, String phone, String email,HttpSession session) {
        System.out.println("studentId:"+studentId);
        Student student=new Student(studentId,name,phone,email);
        System.out.println(student);
        int result = studentService.updateStudentInfo(student);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
}
