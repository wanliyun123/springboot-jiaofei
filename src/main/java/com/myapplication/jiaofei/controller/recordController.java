package com.myapplication.jiaofei.controller;

import com.myapplication.jiaofei.dao.PayrecordMapper;
import com.myapplication.jiaofei.pojo.Payrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

import static com.myapplication.jiaofei.controller.LoginController.useraccount;

@Controller
public class recordController {

    @Autowired
    PayrecordMapper payrecordMapper;

    @RequestMapping("/history")         //处理访问历史账单请求，拿到用户ID，将该用户下的所有充值记录返回给充值界面
    public String getHistory(Model model){
        List<Payrecord> list =payrecordMapper.selectByPrimaryKey(useraccount.getUserId());
        model.addAttribute("all",list);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String formatDate = df.format(useraccount.getUserBorndate());
        return "history";
    }

}
