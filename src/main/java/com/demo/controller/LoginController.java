package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.User;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@GetMapping
	public String home() {
		return "index";
	}
	
	//@RequestMapping(value="/validateuser",method=RequestMethod.POST)
	@PostMapping("/validate")
	public ModelAndView validateUser(HttpSession session,@RequestParam("user") String uname,@RequestParam("password") String pass) {
		//System.out.println(uname+"----"+pass);
		User u=loginService.validateUser(uname,pass);
		
		if(u!=null){
			session.setAttribute("user", u);
			return new ModelAndView("redirect:/products/");
			
		}
		else {
			return new ModelAndView("index","msg","pls reenter crendentials");
		}
	}

}

