package com.chuvakov.hockeymanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chuvakov.hockeymanager.domain.AppUser;
import com.chuvakov.hockeymanager.domain.AppUserRepository;
import com.chuvakov.hockeymanager.domain.SignupForm;

import jakarta.validation.Valid;


@Controller
public class UserController {
	@Autowired
    private AppUserRepository urepository; 
	
    @RequestMapping(value = "signup")
    public String addPlayer(Model model){
    	model.addAttribute("signupform", new SignupForm());
        return "signup";
    }	
    
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	System.out.println(bindingResult.toString());
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	AppUser newUser = new AppUser();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
		    	newUser.setRole("USER");
		    	if (urepository.findByUsername(signupForm.getUsername()) == null) {
		    		urepository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "error.userexists", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "error.pwdmatch", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    }    
}
