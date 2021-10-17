package com.southwind.controller;

import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("type")String type, HttpSession session){
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap)object;
        String result = null;
        String idstr = null;
        long id = 0;
        if(object == null){
            result = "login";
        }else{
            switch (type){
                case "user":
                    User user = new User();
                    idstr = hashMap.get("id")+"";//转成String，而不能装置转换类型！
                    id = Long.parseLong(idstr);
                    String nickname = (String)hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idstr = hashMap.get("id")+"";
                    id = Long.parseLong(idstr);
                    String username2 = (String) hashMap.get("username");
                    admin.setId(id);
                    admin.setUsername(username2);
                    session.setAttribute("admin",admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return  "redirect:/login.html";
    }

}
