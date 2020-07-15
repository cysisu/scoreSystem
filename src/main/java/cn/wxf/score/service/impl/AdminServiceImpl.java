package cn.wxf.score.service.impl;


import cn.wxf.score.entity.Menu;
import cn.wxf.score.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    /************************************Menu相关************************************/
    //教师的左边导航栏
    public List<Menu> getMenus() {
        List<Menu> menus=new ArrayList<Menu>();
        Menu menu=new Menu();
        menu.setMenuId(Long.parseLong("1"));
        menu.setName("后台首页");
        menu.setIcon("&#xe68e;");
        menu.setSpread("false");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("99999"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("2"));
        menu.setName("导入成绩");
//        menu.setIcon("&#xe66f;");
        menu.setSpread("false");
        menu.setHref("/teacher");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9998"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("3"));
        menu.setName("查看成绩");
        menu.setSpread("false");
        menu.setHref("/teacher/findScoreInfo");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9997"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("4"));
        menu.setName("个人信息");
        menu.setSpread("false");
        menu.setHref("/teacher/teacherInfo");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9996"));
        menus.add(menu);

        System.out.println(menu);
        return menus;
    }

    //学生的左边导航栏
    public List<Menu> getStudentMenus() {
        List<Menu> menus=new ArrayList<Menu>();
        Menu menu=new Menu();
        menu.setMenuId(Long.parseLong("1"));
        menu.setName("后台首页");
        menu.setIcon("&#xe68e;");
        menu.setSpread("false");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("99999"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("3"));
        menu.setName("查看成绩");
        menu.setSpread("false");
        menu.setHref("/student/getScoreInfo");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9997"));
        menus.add(menu);

        menu=new Menu();
        menu.setMenuId(Long.parseLong("4"));
        menu.setName("个人信息");
        menu.setSpread("false");
        menu.setHref("/student/studentInfo");
        menu.setParentId(Long.parseLong("0"));
        menu.setSorting(Long.parseLong("9996"));
        menus.add(menu);

        System.out.println(menu);
        return menus;
    }

    @RequestMapping("/main")
    public String getMain() {
        return "/jsp/main";
    }

}
