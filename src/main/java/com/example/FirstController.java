/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;


import com.example.ItemPackage.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author alexi
 */

@Controller
public class FirstController {
    
   @Inject VegetableRepository veges;
   @Inject ItemRepository items;
  
    
    @RequestMapping("/")
    public String MaClasseController(Model m){
        return "index";
    }
    
    
    @RequestMapping("/add-item")
    public String addItem(@Valid Item it){
        items.save(it);
        return "redirect:/";
    }
    
       @RequestMapping("/add-vegetable")
    public String addItem(@Valid Vegetable veges){
        this.veges.save(veges);
        return "redirect:/";
    }
    
    
        @RequestMapping("/suppr-item")
    public String deleteVegetable(
            @RequestParam("id") Long identifiantItem
    ) {
        items.delete(identifiantItem);
        return "redirect:/";
    }
    
    @RequestMapping("/vegetable/{idVege}")
    public String detailsVegetable(
    Model m, @PathVariable long idVege){
        
       Vegetable v= veges.findOne(idVege);
        m.addAttribute("veges", v);
        return "details";
    }
    
    
        @RequestMapping("/TEST")
    public String genererDesDonnees() {

    List<Vegetable> garden = new ArrayList<>();
        
    garden.add(new Vegetable("poireau", "vert", 2));
    garden.add(new Vegetable("épinard", "vert", 3));
    garden.add(new Vegetable("carotte", "orange", 1));
    garden.add(new Vegetable("tomate", "rouge", 2));

    for (Vegetable v : garden)
    {
        veges.save(v);
    }
    
        return "redirect:/";
    }
}