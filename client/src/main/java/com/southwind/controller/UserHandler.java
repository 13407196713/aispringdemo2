package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    /*增*/
    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());//注册时间系统给出
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

    /*删*/
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }

    /*查*/
    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page , @RequestParam("limit") int limit){
        int  index = (page - 1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);;
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index, limit));
        return userVO;
    }


    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

}
