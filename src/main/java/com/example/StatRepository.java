/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.ItemPackage.Stat;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alex
 */
public interface StatRepository extends CrudRepository<Stat, Long>{
}