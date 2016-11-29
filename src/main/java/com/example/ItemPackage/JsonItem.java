/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Alex
 */

public class JsonItem {
    
    private JSONObject jsonItem;
    private List<Item> listItems= new ArrayList<Item>();
    
    public JsonItem(){
    }
    
    public List<Item> getItemList(){
        return this.listItems;
    }
    
    public JSONObject getJsonItem() {
        return jsonItem;
    }

    public JSONObject getJsonItem(int item) throws Exception{
        this.getItem(item);
        return getJsonItem();  
    }
    

    public void setJsonItem(JSONObject jsonItem) {
        this.jsonItem = jsonItem;
    }
        
    public void getItem(int item) throws Exception {
        HttpURLConnection http = new HttpURLConnection();
        String stringItem= http.getItemByNumber(item);
        this.setJsonItem(new JSONObject(stringItem));
    }
    
    public void createItem(int item) throws Exception{
        this.getItem(item);
        Item myItem= new Item(  getId(), getDescription(), getName(), getIcon(), 
                                getBonusStats(), getItemClass(), getDammageMin(),
                                getDammageMax(),getExactMin(), getExactMax(), 
                                getWeaponSpeed(), getDps(), getBaseArmor(),
                                isHasSockets());   
        listItems.add(myItem);
    }
    
    public void CreateItems(){
    List<String> itemsToCreate= ListUsefulItems.getList();
    for(String s: itemsToCreate){
       try{
           createItem(Integer.valueOf(s));
       }
       catch (Exception E){
           System.out.println("com.example.ItemPackage.JsonItem.CreateItems(), impossible to create");
       }
       }
    }
    
    
    
    
    
    public int getId() {
        return jsonItem.getInt("id");
    }
     
    public String getDescription() {
        return jsonItem.getString("description");
    }
 
    public String getName() {
        return jsonItem.getString("name");
    }
       
    public String getIcon() {
        return jsonItem.getString("icon");
    }
       
    public List<Stat> getBonusStats() {
        List<Stat> myList = new ArrayList<>();
        JSONArray tmp = jsonItem.getJSONArray("bonusStats"); 
        for(Object o: tmp){
            JSONObject jsonlineItem=(JSONObject) o;
            int statNumber=jsonlineItem.getInt("stat");
            int amount=jsonlineItem.getInt("amount");
            Stat tmpStat= new Stat(statNumber, amount);
            myList.add(tmpStat);
        }
        return myList;
    }
       
    public int getItemClass() {
        return jsonItem.getInt("ItemClass");
    }
        
    public int getDammageMin() {
        return jsonItem.getInt("min");
    }
    
    public int getDammageMax() {
        return jsonItem.getInt("max");
    }
    
    public int getExactMin() {
        return jsonItem.getInt("exactMin");
    }
      
    public int getExactMax() {
        return jsonItem.getInt("exactMax");
    }
      
    public int getWeaponSpeed() {
        return jsonItem.getInt("weaponSeed");
    }
      
    public int getDps() {
        return jsonItem.getInt("dps");
    }
    
    public int getBaseArmor() {
        return jsonItem.getInt("baseArmor");
    }
        
    public boolean isHasSockets() {
        return jsonItem.getBoolean("hasSockets");
    }

}
