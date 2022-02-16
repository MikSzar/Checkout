package com.checkout.checkout.service;

import com.checkout.checkout.exception.UserNotFoundException;
import com.checkout.checkout.model.Item;
import com.checkout.checkout.model.User;
import com.checkout.checkout.repository.ItemRepository;
import com.checkout.checkout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public User findUserById(Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent())
            return optUser.get();
        else
            throw new UserNotFoundException(userId);
    }


    @Override
    public void UpdateItemQuantity(int itemId, int quantity) {
        Optional<Item> tempItem =itemRepository.findById(itemId);
        Item item = tempItem.get();
        int tempquantity = item.getQuantity();
        tempquantity = tempquantity - 1;
        item.setQuantity(tempquantity);
        itemRepository.save(item);
    }
    @Override
    public List<Item> getUserItems(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
            return user.get().getItems();
        else
            throw new UserNotFoundException(userId);

    }

}
