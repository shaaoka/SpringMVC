package com.team6.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@SessionAttributes(names = {"userName","passWord"})
public class test1 {

	@RequestMapping(path = "/test1.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam("passWord")String passWord,
								@RequestParam("userName")String userName,
								Model m,SessionStatus status) {

		Map<String, String> errors = new HashMap<String, String>();	
		
		m.addAttribute("errors",errors);
		
		if(userName==null || userName.length()==0) {
			errors.put("name", "name is required");
		}
		
		if(passWord==null || passWord.length() == 0) {
			errors.put("passWord","password is error" );
		}
		if(errors!=null && !errors.isEmpty()) {
			return "test1.jsp";
		}
		//導入到頁面就會清除session
		status.setComplete();
		
		m.addAttribute("userName",userName);
		m.addAttribute("passWord",passWord);
		return "success.jsp";
		
		
	}
	
}