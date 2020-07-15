package cn.wxf.score.controller;

import cn.wxf.score.entity.Score;
import cn.wxf.score.entity.Teacher;
import cn.wxf.score.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //返回添加成绩的页面
    @RequestMapping("")
    public String addScore(){
        return "jsp/teacher/addScore";
    }

    //返回老师查看成绩的页面
    @RequestMapping("/findScoreInfo")
    public String getTeacherScore(){
        return "jsp/teacher/scoreInfo";
    }

    //返回老师个人信息页面
    @RequestMapping("/teacherInfo")
    public String getTeacherInfo(){
        return "jsp/teacher/teacherInfo";
    }

    //添加学生成绩
    @RequestMapping(value="/setScore", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> add(@RequestBody Score score, HttpSession session) {
        String teacherId=session.getAttribute("id").toString();
        score.setTeacherId(teacherId);
        System.out.println(score);
        Map<String, Object> map = new HashMap<String, Object>();
        int result=teacherService.insertScore(score);
        if(result>0){
            map.put("status", 1);
        }else{
            map.put("status", 0);
        }
        return map;
    }


    @RequestMapping(value = "/{studentId,subject}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteOrder(@PathVariable("studentId") String studentId,@PathVariable("subject") String subject,HttpSession session) {
        System.out.println("是否请求删除过");
        String teacherId=session.getAttribute("id").toString();
        Score score=new Score(studentId,teacherId,subject);
        int result = teacherService.deleteScore(score);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    //查找符合条件的成绩信息列表
    @RequestMapping(value = "/findScores")
    @ResponseBody
    public Map<String, Object> findScores(@RequestParam("studentId") String studentId,@RequestParam("subject") String subject ,int page, int limit,HttpSession session) {
        String teacherId=session.getAttribute("id").toString();
        Score score=new Score(studentId,teacherId,subject);
        List<Score> scores=teacherService.findScores(score);
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
        String teacherId=session.getAttribute("id").toString();
        List<Score> scoreList = teacherService.getScores(teacherId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", scoreList.size());
        map.put("data", scoreList);
        return map;
    }

    //更新老师的个人信息
    @RequestMapping(value = "/updateTeacherInfo" )
    @ResponseBody
    public Map<String, Object> updateTeacherInfo( String teacherId, String name, String phone, String email,HttpSession session) {
        System.out.println("phone:"+phone);
        Teacher teacher=new Teacher(teacherId,name,phone,email);
        System.out.println(teacher);
        int result = teacherService.updateTeacherInfo(teacher);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }

    @RequestMapping(value = "/updateScore" )
    @ResponseBody
    public Map<String, Object> updateScore( String subject, String studentId, float score, HttpSession session) {
        String teacherId=session.getAttribute("id").toString();
        Score score1=new Score(studentId,teacherId,subject,score);

        int result = teacherService.updateScore(score1);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
}
