package com.faresatoui.userprofileapps.demo.service;

import com.faresatoui.userprofileapps.demo.model.Address;
import com.faresatoui.userprofileapps.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
    }



    @Test
    public void getAnUserByPage() {
        Map<String,Object> result = userService.getUsersByPage(1,4);
        assertEquals(result.get("Current_page"), 1, "Normally will return the current page");
        assertEquals(result.get("Total_of_elements"), Long.valueOf(11), "Normally will return the total of elements");
        assertEquals(result.get("Total_of_pages"), 3, "Normally will return the total of pages");
    }

    @Test
    public void addAnUser() {
        User myUser = new User("Mam","MOMO", "xxxxx@gmail.com", LocalDate.of(2003,7,2), new Address("2400 route des dolines","valbonnes","france",06560),"ma bio i am stranger");
        User userSaved = userService.addAnUser(myUser);
        assertEquals(userSaved.getLastname(), "MOMO", "Should return the same Last Name");
    }

}
