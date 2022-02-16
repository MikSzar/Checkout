package com.checkout.checkout.controller;

import com.checkout.checkout.exception.ItemException;
import com.checkout.checkout.exception.ItemNotFoundException;
import com.checkout.checkout.exception.UserNotFoundException;
import com.checkout.checkout.model.Item;
import com.checkout.checkout.model.User;
import com.checkout.checkout.service.IItemService;
import com.checkout.checkout.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    IUserService userService;
    @Autowired
    IItemService itemService;

    @GetMapping("/")
    public String goToIndexPage() {
        return "index";
    }

    @GetMapping("/success")
    public String CheckItem(@RequestParam Integer userId){

        List<Item> itemList = userService.getUserItems(userId);
        for (int i = 0; i < itemList.size(); i++) {

            Item tempItem = itemList.get(i);
            Integer tempItemId = tempItem.getItemId();
            Integer tempquantity = tempItem.getQuantity();
            if (tempquantity >= 1)
                userService.UpdateItemQuantity(tempItemId, tempquantity);
            else
                throw new ItemException(tempItemId);

        }
        return "success";
    }


    @GetMapping("/details")
    public String goToDetails(ModelMap model, @RequestParam Integer userId) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        List<Item> itemList = userService.getUserItems(userId);
        Double totalprice = 0.0;
        for (int i = 0; i < itemList.size(); i++) {

            Item tempItem = itemList.get(i);
            totalprice = totalprice + tempItem.getPrice();
            model.addAttribute("totalprice", totalprice);
        }

        return "details";
    }

    @GetMapping("/details_item")
    public String goToItemDetails(ModelMap model, @RequestParam Integer itemId) {
        Item item = itemService.findItemById(itemId);

        model.addAttribute("item", item);
        return "details_item";
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView userNotFound(UserNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("UserNotFound");
        return modelAndView;
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ModelAndView itemNotFound(ItemNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("ItemNotFound");
        return modelAndView;
    }

}
