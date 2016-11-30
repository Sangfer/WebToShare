/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;




/**
 *
 * @author Alex
 */
@Data
@Entity
public class Item {

    @Column(name="ITEM_ID")
    @Id
    private long id;
    private String name;


    @OneToMany
    @JoinColumn (name="ITEM_ID")
    private List<Stat> bonusStats;
    private int itemClass; //Arrow, sword etc;


    public Item() {
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    
    public List<Stat> getBonusStats() {
        return bonusStats;
    }

    public void setBonusStats(List<Stat> bonusStats) {
        this.bonusStats = bonusStats;
    }
    
    

    public int getItemClass() {
        return itemClass;
    }

    public void setItemClass(int itemClass) {
        this.itemClass = itemClass;
    }
        
    public Item(long id, String name, int itemClass, List<Stat> bonusStats) {
        this.id = id;
        this.name = name;
        this.itemClass = itemClass; 
        this.bonusStats=bonusStats;

    }

    
}