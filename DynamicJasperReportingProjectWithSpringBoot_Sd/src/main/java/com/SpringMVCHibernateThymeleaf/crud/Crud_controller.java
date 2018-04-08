package com.SpringMVCHibernateThymeleaf.crud;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Crud_controller {
	@Autowired
	Crud_service service;

	@RequestMapping(value = "/page2")
	public String index(Model model) {
		List<Crud_user> userlist = service.browsUser();
		model.addAttribute("userlist", userlist);
		return "page2";
	}

	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("object1", new Crud_user());
		return "page1";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void usrCrud(@RequestBody List<Crud_Dto> user, BindingResult bindingResult, Principal principal) {
		try {
			service.savedata(user);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		

		// return user;

	}

}
