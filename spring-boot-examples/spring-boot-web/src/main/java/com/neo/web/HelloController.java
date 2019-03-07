package com.neo.web;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.neo.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
    @RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		return "hello world";
	}
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/xm")
    public User getUser() {
        User user = new User();
        user.setUserName("小明");
        user.setPassWord("xxxx");
        return user;
    }

}