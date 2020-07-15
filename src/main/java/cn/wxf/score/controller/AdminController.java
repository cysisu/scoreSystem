package cn.wxf.score.controller;

import cn.wxf.score.entity.Menu;
import cn.wxf.score.entity.Student;
import cn.wxf.score.entity.Teacher;
import cn.wxf.score.service.AdminService;
import cn.wxf.score.service.StudentService;
import cn.wxf.score.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //登录日志，输出到D:\\logs目录下
    private static Logger logger= LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String id, String password, String character, HttpServletRequest request, HttpSession session)
            throws ParseException {

        System.out.println("id:"+id+"\tpassword:"+password+"\tcharacter:"+character);
        session.setAttribute("id",id);
        session.setAttribute("character",character);
        Map<String, Object> map = new HashMap<String, Object>();
        if(character.equals("student")){
            System.out.println("登陆进入student");
            List<Student> studentList=studentService.getStudent(id,password);
            int size=studentList.size();
            if(size>0){
                //状态为2的时候为学生登录
                map.put("status", 2);
                Student student=studentList.get(0);
                session.setAttribute("name",student.getName());
                session.setAttribute("phone",student.getPhone());
                session.setAttribute("email",student.getEmail());
            }
            else{
                map.put("status", 0);
            }

        }
        else if(character.equals("teacher")){
            logger.debug("教师编号是："+id+" 请求登录");
            List<Teacher> teacherList=teacherService.getTeacher(id,password);
            int size=teacherList.size();
            if(size>0){
                logger.debug("教师编号是："+id+" 登录成功");
                map.put("status", 1);
                Teacher teacher=teacherList.get(0);
                session.setAttribute("name",teacher.getName());
                session.setAttribute("phone",teacher.getPhone());
                session.setAttribute("email",teacher.getEmail());
            }
            else{
                logger.debug("教师编号是："+id+" 登录失败，用户名或者密码错误");
                map.put("status", 0);
            }
        }
        return map;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map<String, Object> register(String id, String password, String character, HttpServletRequest request, HttpSession session)
            throws ParseException {
        System.out.println("请求注册");
        logger.info("id为："+id+" 请求注册");
        Map<String, Object> map = new HashMap<String, Object>();
        if(character.equals("student")){
            logger.debug("学生编号是："+id+" 请求注册");
            List<Student> studentList=studentService.getStudent(id);
            int size=studentList.size();
            if(size>0){
                //用户已经存在
                map.put("status", 0);
            }
            else{
                studentService.insertStudent(id,password);
                map.put("status", 1);
            }

        }
        else if(character.equals("teacher")){
            logger.debug("教师编号是："+id+" 请求注册");
            List<Teacher> teacherList=teacherService.getTeacher(id);
            int size=teacherList.size();
            if(size>0){
                //用户已经存在
                map.put("status", 0);
            }
            else{
                teacherService.insertTeacher(id,password);
                map.put("status", 1);
            }
        }
        return map;
    }


    @RequestMapping("/getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session){
        String character=session.getAttribute("character").toString();
        //如何是老师，进入首页和学生的左边导航栏是不同的
        List<Menu> menus;
        if(character.equals("student")){
            menus = adminService.getStudentMenus();
        }
        else{
            menus = adminService.getMenus();
        }
        System.out.println("大小："+menus.size());
        return menus;
    }

    @RequestMapping("/main")
    public String getMain() {
        return "/jsp/main";
    }

    @RequestMapping("/studentMain")
    public String getStudent() {
        return "/jsp/studentMain";
    }
}
