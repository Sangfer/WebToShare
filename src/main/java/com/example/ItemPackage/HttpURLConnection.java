/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Alex
 */
public class HttpURLConnection {
    
    private final String apiKey="znvu7s744nxkmbjx66rcywvjqrk8h7f8";
    private final String USER_AGENT = "Mozilla/5.0";

     public String getItemByNumber(int itemNumber) throws Exception {

                //The Url of the api for getting items
		String url = "https://us.api.battle.net/wow/item/"+itemNumber+"?locale=en_US&apikey="+apiKey;
		URL obj = new URL(url);
                //set of a new connection
		java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
                //If not success
                if( responseCode!= 200){
                    throw new Exception("HTTP Error code, ressource unreachable");
                }

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

                return response.toString();

	}
}
