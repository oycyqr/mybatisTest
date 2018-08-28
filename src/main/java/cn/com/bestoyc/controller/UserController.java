package cn.com.bestoyc.controller;

import cn.com.bestoyc.dao.UserBaseDao;
import cn.com.bestoyc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author oyc
 * @Title:
 * @Description:用户控制类
 * @date 2018/7/2922:45
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("getUserName")
    public String getUserName(HttpServletRequest request , HttpServletResponse response) throws Exception{
        System.out.println("getUserName");
        UserBaseDao ub = new UserBaseDao();
        ub.getById(User.class,"1");
        System.out.println(ub);
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return "index";
    }
}
