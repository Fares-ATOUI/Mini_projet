package com.faresatoui.userprofileapps.demo.repository;

import com.faresatoui.userprofileapps.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void returnUserWhenFindByLogin () {
        User result = userRepository.findUserByLogin("aaaa");
        assertEquals(result.getLogin(), "aaaa", "Return the same Login");
    }

}
