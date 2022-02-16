package com.checkout.checkout.service;


import com.checkout.checkout.model.Item;
import com.checkout.checkout.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

    @MockBean
    ItemRepository mockRepo;

    @InjectMocks
    ItemService service;


    @Test
    public void test_findItemById(){

        Item item = new Item(50,"test_item","we are testing",10.0, 4);
        item.setItemId(20);
        Mockito.when(mockRepo.findById(item.getItemId())).thenReturn(Optional.of(item));
        service.findItemById(item.getItemId());
        Mockito.verify(mockRepo).findById(item.getItemId());
    }

    @Test
    public void test_deleteItem(){

        List<Item> expectedList = new ArrayList<>();
        Item item = new Item(50,"test_item","we are testing",10.0, 4);
        expectedList.add(item);
        Item deleteitem = new Item(50,"test_item","we are testing",10.0, 4);
        deleteitem.setItemId(20);
        Mockito.when(mockRepo.findById(deleteitem.getItemId())).thenReturn(Optional.of(deleteitem));
        service.deleteItemById(deleteitem.getItemId());
        Mockito.verify(mockRepo).delete(deleteitem);
    }

    @Test
    public void test_saveItem(){

        Item item = new Item(50,"test_item","we are testing",10.0, 4);
        Mockito.when(mockRepo.save(item)).thenReturn(item);
        service.save(item);
        Mockito.verify(mockRepo).save(item);
    }
}
