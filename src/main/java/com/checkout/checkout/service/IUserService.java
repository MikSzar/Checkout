package com.checkout.checkout.service;

import com.checkout.checkout.model.Item;
import com.checkout.checkout.model.User;

import java.util.List;

public interface IUserService {

    User findUserById(Integer userId);
    List<Item> getUserItems(Integer userId);
    void UpdateItemQuantity(int itemId, int quantity);
}
