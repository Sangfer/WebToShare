/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;

import org.json.JSONObject;

/**
 *
 * @author Alex
 */

public class JsonItem {
    
    private JSONObject jsonItem;
    
    public JsonItem(){
    }

    public JSONObject getJsonItem() {
        return jsonItem;
    }

    public void setJsonItem(JSONObject jsonItem) {
        this.jsonItem = jsonItem;
    }
        
    public void GetItem(int item) throws Exception {
    HttpURLConnection http = new HttpURLConnection();
    String stringItem= http.getItemByNumber(item);
    this.setJsonItem(new JSONObject(stringItem));
    }
}
