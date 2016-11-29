/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



/**
 *
 * @author Alex
 */
@Entity
public class Item {
    
    @Id
    @NotNull
    private int id;


    private String description;
    private String name;
    private String icon;
    private List<Stat> bonusStats;
    private int itemClass; //Arrow, sword etc;
    //"itemSubClass":5,
    private int dammageMin;
    private int dammageMax;
    private int exactMin;
    private int exactMax;
    private int weaponSpeed;
    private int dps;
    private int baseArmor;
    private boolean hasSockets;

    public Item() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public int getDammageMin() {
        return dammageMin;
    }

    public void setDammageMin(int dammageMin) {
        this.dammageMin = dammageMin;
    }

    public int getDammageMax() {
        return dammageMax;
    }

    public void setDammageMax(int dammageMax) {
        this.dammageMax = dammageMax;
    }

    public int getExactMin() {
        return exactMin;
    }

    public void setExactMin(int exactMin) {
        this.exactMin = exactMin;
    }

    public int getExactMax() {
        return exactMax;
    }

    public void setExactMax(int exactMax) {
        this.exactMax = exactMax;
    }

    public int getWeaponSpeed() {
        return weaponSpeed;
    }

    public void setWeaponSpeed(int weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public boolean isHasSockets() {
        return hasSockets;
    }

    public void setHasSockets(boolean hasSockets) {
        this.hasSockets = hasSockets;
    }

    public Item(int id, String description, String name, String icon, List<Stat> bonusStats, int itemClass, int dammageMin, int dammageMax, int exactMin, int exactMax, int weaponSpeed, int dps, int baseArmor, boolean hasSockets) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.icon = icon;
        this.bonusStats = bonusStats;
        this.itemClass = itemClass;
        this.dammageMin = dammageMin;
        this.dammageMax = dammageMax;
        this.exactMin = exactMin;
        this.exactMax = exactMax;
        this.weaponSpeed = weaponSpeed;
        this.dps = dps;
        this.baseArmor = baseArmor;
        this.hasSockets = hasSockets;
    }

    
}

