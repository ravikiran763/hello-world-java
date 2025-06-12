package com.myapp.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	private final Map<Integer, String> items = new HashMap<>();
    private int currentId = 1;

	@Override
	public String getItem(Integer id) {
		 if (!items.containsKey(id)) {
	            throw new NoSuchElementException("Item not found");
	        }
	        return items.get(id);
	}

	@Override
	public String createItem(String newItem) {
		items.put(currentId++, newItem);
        return "Item created successfully";
	}

	@Override
	public String updateItem(Integer id, String updatedItem) {
		if (!items.containsKey(id)) {
            throw new NoSuchElementException("Item not found");
        }
        items.put(id, updatedItem);
        return "Item updated successfully";
	}

	@Override
	public String deleteItem(Integer id) {
		if (!items.containsKey(id)) {
            throw new NoSuchElementException("Item not found");
        }
        items.remove(id);
        return "Item deleted successfully";
	}

	@Override
	public Collection<String> getAllItems() {
		return items.values();
	}

}
