/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;



/**
 *
 * @author Alex
 */

public class Stat{
    
        int statNumber;
        int amount;


    public Stat(){
        
    }

    public Stat(int statNumber, int amount){
        this.statNumber=statNumber;
        this.amount=amount;
    }

    public int getStatNumber() {
        return statNumber;
    }

    public void setStatNumber(int statNumber) {
        this.statNumber = statNumber;
    }
    
    }