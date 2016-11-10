package com.items.service;

import com.items.domain.Item;

import java.util.List;

public interface ItemService {
    public Item save(Item i);
    public List get();
    public void delete(Long id);
}
