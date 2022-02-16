package com.checkout.checkout.service;


import com.checkout.checkout.model.Item;
import com.checkout.checkout.model.User;
import com.checkout.checkout.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @MockBean
    UserRepository mockRepo;

    @InjectMocks
    UserService service;

    @Test
    public void test_findUserById(){

        User user = new User(30, "Mikolaj", "Szargut");
        user.setUserId(20);
        Mockito.when(mockRepo.findById(user.getUserId())).thenReturn(Optional.of(user));
        service.findUserById(user.getUserId());
        Mockito.verify(mockRepo).findById(user.getUserId());
    }

}
