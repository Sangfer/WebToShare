/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.ItemPackage.Item;
import com.example.ItemPackage.JsonItem;
import com.example.ItemPackage.Stat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alex
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository Irepository;
        private final StatRepository Srepository;


    public DatabaseLoader(ItemRepository irep, StatRepository srep) {
        this.Irepository = irep;
                this.Srepository= srep;
    }

    @Override
    public void run(String... strings) throws Exception {
            JsonItem myjson = new JsonItem();
            myjson.CreateItems();
            List<Item> myItemList=myjson.getItemList();
            for(Item i: myItemList){
                List<Stat> myStatList=i.getBonusStats();
                for(Stat s: myStatList)
                    this.Srepository.save(s);
                this.Irepository.save(i);

            }
    }


}