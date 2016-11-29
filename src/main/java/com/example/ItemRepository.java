package com.example;

import com.example.ItemPackage.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexi
 */

public interface ItemRepository extends CrudRepository<Item, Long>{    
}