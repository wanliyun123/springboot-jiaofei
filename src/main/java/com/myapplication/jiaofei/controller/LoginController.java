package com.myapplication.jiaofei.controller;

import com.myapplication.jiaofei.dao.UseraccountMapper;
import com.myapplication.jiaofei.dao.UserpwdMapper;
import com.myapplication.jiaofei.pojo.Useraccount;
import com.myapplication.jiaofei.pojo.Userpwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class LoginController {

    private static Userpwd userpwd;
    public static Useraccount useraccount;
//    private static Integer a = null;

    @Autowired
    UserpwdMapper userpwdMapper;

    @Autowired
    UseraccountMapper useraccountMapper;

    @RequestMapping({"/","/main","/main.html"})
    public String index(){
        return "login";
    }

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
//        @RequestParam("msg") Model model;
//        HttpSession session;
        useraccount = useraccountMapper.selectByPrimaryKey(userpwd.getUserId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(useraccount.getUserBorndate());
        map.put("date",formatDate);
        map.put("useraccount",useraccount);

        return "list";
    }

    @RequestMapping("/logout")
    public String logout(Map<String,Object> map,HttpSession session){
        session.removeAttribute("User");
        map.put("msg","您已成功退出");
        return "login";
    }


    @RequestMapping("/list/addmoney")
    public String addMoneyList(Map<String,Object> map){
        useraccount = useraccountMapper.selectByPrimaryKey(userpwd.getUserId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(useraccount.getUserBorndate());
        map.put("date",formatDate);
        map.put("useraccount",useraccount);
        map.put("msgformoneyincre","充值失败，余额不足");

        return "list";
    }

    @PostMapping({"/login"})
    public String login(@RequestParam("Username") Integer username,
                        @RequestParam("Password") String password,
                        HttpSession session,    //从登陆页面拿到username以及password，与数据库的userpwd表单存储的密码
                        Model model){           //进行匹配，如果能匹配成功，放行登陆，来到个人信息页面；如果不匹配，打
                                                // 印错误信息，返回给登陆页面。

//        System.out.println(username+"    "+password);
        userpwd = userpwdMapper.selectByPrimaryKey(username);
        if(userpwd == null){
//            System.out.println("login");
            model.addAttribute("msg","用户名不存在，请注册。");
            return "login";
        }
        else{
            if(userpwd.getUserPwd().equals(password)){
//                System.out.println("list");         //登陆成功，session添加user信息，对后续的访问页面进行session拦截
                                                    //未登陆的用户禁止访问除主页以外的页面。
                session.setAttribute("User",username);
//                a = username;
                return "redirect:/list";
            }
            else{
//                System.out.println("login");
                model.addAttribute("msg","用户名错误，请重新登录。");
                return "login";
            }
        }

    }
}
