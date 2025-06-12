package com.myapp.service;

import java.util.Collection;

public interface ItemService {
public Collection<String> getAllItems();
public String getItem (Integer id);
public String createItem(String newItem);
public String updateItem (Integer id, String updatedItem);
public String deleteItem (Integer id);


}
