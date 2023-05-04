package org.jsp.usermvcapp.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsp.usermvcapp.dto.User;
import org.jsp.usermvcapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes(names = { "u" })
public class UserController
{
	@Autowired
	private UserService service;
	
	@RequestMapping("/load")
	public ModelAndView load(ModelAndView view,@RequestParam int choice)
	{
		if(choice == 1)
		  view.setViewName("register");
		if(choice ==2)
			view.setViewName("edit");
		 view.addObject("user",new User());
		return view;
	}
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user,ModelAndView view)
	{
		user =service.saveuser(user);
		view.setViewName("print");
		view.addObject("message", "user save with id:"+user.getId());
		return view;
	}
	@RequestMapping(value = "/loginuser",method = RequestMethod.POST)
	public String login(@RequestParam long phone,@RequestParam String password,Model view)
	{
		User user=service.verifyuser(phone, password);
		System.out.println("@@@@@:"+user);
		if(user!=null)
		{
			view.addAttribute("user",user);
			return "home";
		}
		else {
			view.addAttribute("message","invalid phone number or password");
			return "login";
		}
	}
	@RequestMapping("/edit")
	public ModelAndView updateUser(@ModelAttribute User u,ModelAndView view)
	{
		u=service.updateuser(u);
		view.addObject("user",u);
		view.setViewName("print");
		view.addObject("message","user updated succesfully");
		return view;
	}
	
}
