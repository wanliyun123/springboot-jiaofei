package com.myapplication.jiaofei.controller;

import com.myapplication.jiaofei.dao.PayrecordMapper;
import com.myapplication.jiaofei.dao.UseraccountMapper;
import com.myapplication.jiaofei.pojo.Payrecord;
import com.myapplication.jiaofei.pojo.Useraccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PayController {

    private static Useraccount useraccount;
    private static Double left;
//    private static Map<String,Object> map = new HashMap<>();

    @Autowired
    UseraccountMapper useraccountMapper;

    @Autowired
    PayrecordMapper payrecordMapper;

    @RequestMapping("/addmoney/{userId}")
    public String success(@PathVariable("userId") Integer userId){
        useraccount = useraccountMapper.selectByPrimaryKey(userId);

        return "addmoney";
    }


    @PostMapping("/moneyincre")
    public String moneyincre(@RequestParam("typeId") Integer typeId,//从form表单获取充值id以及充值的金额。
                                                                    //typeid：1，2，3分别代表水费电费话费，从选择框中获取值
                             @RequestParam("money") Double money,Map<String,Object> map){
//        System.out.println(typeId+"  还未插值   "+money); //控制台打印状态信息。
//        将从充值页面获得的充值金额，与用户账户的余额相减得到剩下的钱，如果leftMoney < 0 那么打印充值失败信息，
//        不将此次充值写入数据库，直接返回list页面。
        System.out.println(useraccount);
        left = useraccount.getUserMoney()-money;
//        System.out.println(left+"这是余额");
        if(left < 0){
//            System.out.println("充值失败");
            map.put("msg","余额不足，充值失败");
            return "redirect:/list/addmoney";
        }
        else{
            if(typeId == 1){//typeId == 1 充值的为水费，将money与水费相加，写入mysql，将leftMoney写入用户余额账户。
                            // 一些typeId：2，3同理；
                useraccount.setUserMoney(left);
                useraccount.setWaterPay(useraccount.getWaterPay()+money);
                useraccountMapper.updateByPrimaryKey(useraccount);
                Payrecord payrecord=new Payrecord();
                payrecord.setUserId(useraccount.getUserId());
                payrecord.setTypeId(typeId);
                payrecord.setDetails("水费充值");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formatDate = df.format(new Date());
                payrecord.setPayTime(new Date());
                payrecord.setPayId((int)(Math.random()*1000)+1);
                payrecord.setPayMoney(money);
                System.out.println("水费插入成功");
                payrecordMapper.insert(payrecord);

            }
            if(typeId == 2){
                useraccount.setUserMoney(left);
                useraccount.setElecPay(useraccount.getElecPay()+money);
                useraccountMapper.updateByPrimaryKey(useraccount);
                Payrecord payrecord=new Payrecord();
                payrecord.setUserId(useraccount.getUserId());
                payrecord.setTypeId(typeId);
                payrecord.setDetails("电费充值");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formatDate = df.format(new Date());
                payrecord.setPayTime(new Date());
                payrecord.setPayId((int)(Math.random()*1000)+1);
                payrecord.setPayMoney(money);
                System.out.println("电费插入成功");
                payrecordMapper.insert(payrecord);
            }
            if(typeId == 3){
                useraccount.setUserMoney(left);
                useraccount.setPhonePay(useraccount.getPhonePay()+money);
                useraccountMapper.updateByPrimaryKey(useraccount);
                Payrecord payrecord=new Payrecord();
                payrecord.setUserId(useraccount.getUserId());
                payrecord.setTypeId(typeId);
                payrecord.setDetails("话费充值");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String formatDate = df.format(new Date());
                payrecord.setPayTime(new Date());
                payrecord.setPayId((int)(Math.random()*1000)+1);
                payrecord.setPayMoney(money);
                System.out.println("话费插入成功");
                payrecordMapper.insert(payrecord);
            }
        }
//        System.out.println("信息打印");
//        System.out.println(payrecord.toString());
        return "redirect:/list";
    }



}
