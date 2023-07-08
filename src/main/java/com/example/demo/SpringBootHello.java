package com.example.demo;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SpringBootHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/hello")
	public String hello(){
		return "這是 Spring Boot 的 Hello Weego start !";
	}
	
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistForm(@ModelAttribute("user") User user) {
        // 在這裡處理用戶註冊邏輯
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
    	//
        return "login";
    }
    
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user) {
        // 在這裡處理用戶登入驗證
        return "redirect:/index";
    }

}