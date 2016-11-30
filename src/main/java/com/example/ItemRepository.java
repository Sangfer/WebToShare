/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.ItemPackage.Item;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexi
 */

public interface ItemRepository extends CrudRepository<Item, Long>{
}