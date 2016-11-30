/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;


import com.example.security.user.User;
import com.example.security.user.UserRepository;
import com.example.security.user.UserService;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Clement
 */

@Controller
public class FirstController {
    
    private TmpUser user=null;
    
    @Inject
    UserService service = new UserService();
    
    @Inject
    UserRepository userRepo;  
    
    @RequestMapping("/")
    public String index(Model m, Authentication auth){    
        if(auth!=null)
            if(auth.isAuthenticated())
            {
                //System.out.println(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
                m.addAttribute("user", ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
            }
            else
                m.addAttribute("user", null);
        else
            m.addAttribute("user", null);
        return "index";
    }
    
    @RequestMapping("/connexion")
    public String connexion(Model m, Authentication auth)
    {
         m.addAttribute("u", new User());
         return "connexion";
    }
    
    @RequestMapping("/inscription")
    public String inscription(Model m)
    {
        m.addAttribute("u", new TmpUser());
        return "inscription";
    }
    
    @RequestMapping("/saveUser")
    public String saveUser(@Valid TmpUser u)
    {
        System.out.println(""+u.getPassword());
        User uti = new User(u.getLogin());
        service.saveUserComputingDerivedPassword(uti, u.getPassword());
        return "redirect:/";
    }
    
    @RequestMapping("/MYlogin")
    public String myLogin(Model m)
    {
        return "redirect:/";
    }
    
    @RequestMapping("/build")
    public String build(Model m, Authentication auth)
    {
        if(auth!=null)
            if(auth.isAuthenticated())
            {
                //System.out.println(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
                m.addAttribute("user", ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
            }
            else
                m.addAttribute("user", null);
        else
            m.addAttribute("user", null);
        return "react-part";
    }
}