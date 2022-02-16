package com.checkout.checkout.service;

import com.checkout.checkout.model.Item;

public interface IItemService {

    void save(Item item);

    Item findItemById(Integer itemId);

    void deleteItemById(Integer itemId);
}
