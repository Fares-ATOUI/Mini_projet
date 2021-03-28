package com.faresatoui.userprofileapps.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.faresatoui.userprofileapps.demo.model.Address;
import com.faresatoui.userprofileapps.demo.model.User;
import com.faresatoui.userprofileapps.demo.repository.UserRepository;
import com.faresatoui.userprofileapps.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepo;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() {

        this.mvc =
                MockMvcBuilders
                        .webAppContextSetup(ctx)
                        .defaultRequest(get("/*"))
                        .defaultRequest(post("/*"))
                        .build();

    }


    @Test
    public void getUsersByLogin() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/users/find/{login}", "aaaa")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("aaaa"));
    }

    @Test
    public void getUsersByPage() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addUser() throws Exception
    {
        User myUser = new User("Mama","MAMAA", "test@gmail.com", LocalDate.of(2000,2,12), new Address("2400 route des dolines","valbonnes","france",06560),"ma bio I am a stranger");

        mvc.perform(MockMvcRequestBuilders.post("/users")
                .content(asJsonString(myUser))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
