package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import com.example.demo.entity.User;
//import com.example.demo.User
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;


@Controller
public class SpringBootHello {
	
	@Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/hello")
	public String hello(){
		return "這是 Spring Boot 的 Hello Weego start !";
	}
	
	@GetMapping("/register")
    public String showRegistPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistForm(@ModelAttribute("user") User user) {
        // 在這裡處理用戶註冊邏輯
    	userRepository.save(user);
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginPage(Model model) {
    	model.addAttribute("user", new User());
    	//
        return "login";
    }
    
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user) {
        // 在這裡處理用戶登入驗證
        return "redirect:/index";
    }
    
    
    @GetMapping("/index")
    public String showIndexPage(Model model) {
    	model.addAttribute("user", new User());
    	//
        return "index";
    }

}
