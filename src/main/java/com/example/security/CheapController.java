/*
 * 
 */

package com.example.security;


import com.example.security.user.UserRepository;
import com.example.security.user.UserService;
import javax.inject.Inject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 
 */
@Controller
@RequestMapping("/s")
public class CheapController {

    @Inject
    UserService userService;
    
    @Inject
    UserRepository userRepo;

    
    @RequestMapping(value = "/users")
	public String manageUsers(Model model, Authentication auth) {
        String u = auth.getName();
		model.addAttribute("username", u);
        model.addAttribute("users", userService.listAllUsers());
        return "users........";
    }
}
