/*
 * To change this license header,choose License Headers in Project Properties.
 * To change this template file,choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ItemPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alex
 */
public class ListUsefulItems {
    
   private static final List<String> listUsefulItemId = new ArrayList<String>(Arrays.asList(
                        "138211","138212","138214","138215","138216","138217","138218",
                        "138219","138220","138221","138222","138224","138225","139187",
                        "139188","139189","139190","139191","139192","139193","139194",
                        "139195","139196","139197","139198","139199","139200","139201",
                        "139202","139203","139204","139205","139206","139207","139208",
                        "139209","139211","139212","139213","139214","139215","139216",
                        "139217","139218","139219","139220","139221","139222","139224",
                        "139225","139226","139227","139228","139229","139230","139231",
                        "139232","139233","139234","139235","139236","139237","139238",
                        "139239","139248","139320","139321","139322","139323","139324",
                        "139325","139326","139327","139328","139329","139330","139332",
                        "139333","139334","139335","139336","140993","140996","141694",
                        "141695","141696"));
   
   public static List<String> getList(){
       return listUsefulItemId;
   }
   
}
