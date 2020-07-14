package cn.wxf.score.service;


import cn.wxf.score.entity.Menu;

import java.util.List;

public interface AdminService {
    /************************Menu相关************************/
    List<Menu> getMenus();
    //学生的左边导航栏
    List<Menu> getStudentMenus();
}
