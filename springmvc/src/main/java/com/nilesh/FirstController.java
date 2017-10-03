package com.nilesh;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class FirstController {
	
	
	@Autowired(required=true)
	UserDao userDao=null;
	
	
	@RequestMapping(value="/AddUser")
	public ModelAndView addUser() {

		System.out.println("User added :");

		ModelAndView mv = new ModelAndView("AddUser");

		return mv;
	}
	
	@RequestMapping(value="/processAddUser", method = RequestMethod.POST)
	public ModelAndView processAddUser(@ModelAttribute User user, @ModelAttribute Address addr){
		
		System.out.println("processAdduser :"+ user);
		System.out.println("addr :"+ addr);
		
		user.setAddress(addr);
		
		System.out.println("processAdduser :"+ user);
		ModelAndView mv = new ModelAndView("AddUserProcessed");
		userDao.addUser(user,addr);
		return mv;
		
	}
	
	

}
