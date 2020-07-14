package cn.wxf.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("")
    public String getLogin(HttpSession session){
        //主要是为了退出登录的时候清楚session
        session.invalidate();
        return "login";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "teacherIndex";
    }

    @RequestMapping("/studentIndex")
    public String getStudentIndex(){
        return "studentIndex";
    }
}


