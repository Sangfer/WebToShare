/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;


import com.example.security.user.User;
import com.example.security.user.UserRepository;
import com.example.security.user.UserService;

import com.example.ItemPackage.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Clement
 */

@Controller
public class FirstController {
    
    private Utilisateur user=null;
    
    @Inject
    UserService service = new UserService();
    
    @Inject
    UserRepository userRepo;  
    
    @RequestMapping("/")
    public String MaClasseController(Model m, Authentication auth){
        if(auth!=null)
            m.addAttribute("user", auth.getName());
        else
            m.addAttribute("user", null);
        return "index";
    }
    
    @RequestMapping("/connexion")
    public String connexion(Model m, Authentication auth)
    {
         m.addAttribute("user", auth.isAuthenticated());
         m.addAttribute("u", new User());
         return "connexion";
    }
    
    @RequestMapping("/inscription")
    public String inscription(Model m)
    {
        m.addAttribute("u", new Utilisateur());
        return "inscription";
    }
    
   @RequestMapping("/check")
    public String checkUser(@Valid Utilisateur u){
        
        return "redirect:/";
    }
    
    @RequestMapping("/persiUtilisateur")
    public String persoUtilisateur(@Valid Utilisateur u)
    {
        System.out.println(""+u.getMotDePasse());
        User uti = new User(u.getLogin());
        service.saveUserComputingDerivedPassword(uti, u.getMotDePasse());
        return "redirect:/";
    }
        
}