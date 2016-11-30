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

    public JSONObject getJsonItem(long item) throws Exception{
        this.getItem(item);
        return getJsonItem();  
    }
    

    public void setJsonItem(JSONObject jsonItem) {
        this.jsonItem = jsonItem;
    }
        
    public void getItem(long item) throws Exception {
        HttpURLConnection http = new HttpURLConnection();
        String stringItem= http.getItemByNumber(item);
        this.setJsonItem(new JSONObject(stringItem));
    }
    
    public void createItem(long item) throws Exception{
        this.getItem(item);
        /*Item myItem= new Item(  getId(), getDescription(), getName(), getIcon(), 
                                getBonusStats(), getItemClass(), getDammageMin(),
                                getDammageMax(),getExactMin(), getExactMax(), 
                                getWeaponSpeed(), getDps(), getBaseArmor(),
                                isHasSockets()); */ 
         Item myItem= new Item(getId(), getName(),  getItemClass(), getBonusStats());
        listItems.add(myItem);
    }
    
    
    public void checkItem(){
        for(int i=0; i<20; i++)
            System.out.println("............");
        for(Item it: listItems){
            System.out.println("Showing Item have been created");
            System.out.println(it.getId());
            System.out.println(it.getName());
                        System.out.println("............");
            List<Stat> listStat=it.getBonusStats();
            for(Stat t: listStat){
                System.out.println("Stat number:"+t.statNumber);
                                System.out.println("Stat amount"+t.amount);

            }


        
    }
    }
    
    public void CreateItems(){
    List<String> itemsToCreate= ListUsefulItems.getList();
    
    for(String s: itemsToCreate){
        System.out.println(s);
       try{
           createItem(Integer.valueOf(s));
           
       }
       catch (Exception E){
           System.out.println("com.example.ItemPackage.JsonItem.CreateItems(), impossible to create");
       }
       }
    }
    
    
    
    
    
    public long getId() {
        return jsonItem.getLong("id");
    }
     
 
 
    public String getName() {

        return jsonItem.getString("name");
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
        return jsonItem.getInt("itemClass");
    }

}
