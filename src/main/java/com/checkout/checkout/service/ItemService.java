package com.checkout.checkout.service;

import com.checkout.checkout.exception.ItemNotFoundException;
import com.checkout.checkout.model.Item;
import com.checkout.checkout.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void save(Item item) {

        itemRepository.save(item);

    }

    @Override
    public Item findItemById(Integer itemId) {
        Optional<Item> optItem = itemRepository.findById(itemId);
        if (optItem.isPresent())
            return optItem.get();
        else
            throw new ItemNotFoundException(itemId);

    }

    @Override
    public void deleteItemById(Integer itemId) {

        itemRepository.delete(findItemById(itemId));

    }
}
