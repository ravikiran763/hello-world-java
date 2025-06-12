package com.my.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myapp.service.ItemService;

import java.util.*;

@RestController
@RequestMapping("/api/items") // Base path for all endpoints in this controller
public class ItemController {
	
	@Autowired
	
	private ItemService itemService;


    

    // GET all items
    @GetMapping
    public Collection<String> getAllItems() {
    	return itemService.getAllItems();
        
    }

    // GET a single item by ID
    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
    	
    	return itemService.getItem(id);
       
    }

    // POST a new item
    @PostMapping
    public String createItem(@RequestBody String newItem) {
    	return itemService.createItem(newItem);
        
    }

    // PUT to update an existing item
    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id, @RequestBody String updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    // DELETE an item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
    	return itemService.deleteItem(id);
        
    }
}
