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

    @RequestMapping("/getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session){
        List<Menu> menus = adminService.getMenus();
        System.out.println("大小："+menus.size());
        return menus;
    }

    @RequestMapping("/main")
    public String getMain() {
        return "/jsp/main";
    }
}
