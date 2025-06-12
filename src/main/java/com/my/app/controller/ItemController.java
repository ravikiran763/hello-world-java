package com.my.app.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/items") // Base path for all endpoints in this controller
public class ItemController {

    private final Map<Integer, String> items = new HashMap<>();
    private int currentId = 1;

    // GET all items
    @GetMapping
    public Collection<String> getAllItems() {
        return items.values();
    }

    // GET a single item by ID
    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
        if (!items.containsKey(id)) {
            throw new NoSuchElementException("Item not found");
        }
        return items.get(id);
    }

    // POST a new item
    @PostMapping
    public String createItem(@RequestBody String newItem) {
        items.put(currentId++, newItem);
        return "Item created successfully";
    }

    // PUT to update an existing item
    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id, @RequestBody String updatedItem) {
        if (!items.containsKey(id)) {
            throw new NoSuchElementException("Item not found");
        }
        items.put(id, updatedItem);
        return "Item updated successfully";
    }

    // DELETE an item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        if (!items.containsKey(id)) {
            throw new NoSuchElementException("Item not found");
        }
        items.remove(id);
        return "Item deleted successfully";
    }
}
