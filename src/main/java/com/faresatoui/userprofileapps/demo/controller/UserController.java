package com.faresatoui.userprofileapps.demo.controller;

import com.faresatoui.userprofileapps.demo.exception.AddUserException;
import com.faresatoui.userprofileapps.demo.model.User;
import com.faresatoui.userprofileapps.demo.service.UserService;
import com.faresatoui.userprofileapps.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(UserController.class.getName());

    /**
     * Define Constant for authorised country
     */
    public static final String COUNTRY_AUTHORISED = "France";

    /**
     * In order to get Users by login.
     * @param login, path variable to find users
     * @return User that match with login
     */
    @GetMapping("/find/{login}")
    public User getUserByLogin(@PathVariable String login){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO," GetUserByLogin is starting GET('/users/find/{login}')");
        login = login.toLowerCase();
        System.out.println("LOGIN : "+ login);
        User result = userService.getUserByLogin(login);
        System.out.println("RESULTAT : "+ result);
        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO," GetUserByLogin is finishing in GET('/users/find/{login}') "+ time + " ms");
        return result;
    }


    /**
     * In order to get users with pagination
     * @param page, it is used to set the page number. (default value = 0)
     * @param size, it is used to set the size of pages.(default value = 0)
     * @return Map<String,Object> to handle response
     */
    @GetMapping("")
    public Map<String, Object> getUsersByPage(@RequestParam(name="page", defaultValue = "0") int page, @RequestParam(name="size", defaultValue = "5") int size){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO," GetUsersByPage is starting GET('/users')");

        Map<String,Object> result = userService.getUsersByPage(page,size);
        time = System.currentTimeMillis() - time ;
        logger.log(Level.INFO," GetUsersByPage is finishing GET('/users') in "+ time+ " ms");
        return result;
    }



    /**
     * Use to insert User
     * @param user, user to insert inside database
     * @return a ResponseEntity or throw an error
     */
    @PostMapping("")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        long time = System.currentTimeMillis();
        logger.log(Level.INFO,"addUser is starting POST('/users')");
        if(!user.getAddress().getCountry().equalsIgnoreCase(COUNTRY_AUTHORISED)){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO,"addUser is finishing in POST('/users') "+ time + " ms");
            throw new AddUserException("The country Not Allowed");
        }
        if(!CommonUtils.ageAuthorized(user.getBirthDate())){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO," addUser is finishing in POST('/users') "+ time + " ms");
            throw new AddUserException("the age lower than 18");
        }

        // set login to LowerCase
        user.setLogin(user.getLogin().toLowerCase());

        User userSaved = userService.addAnUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("userId", userSaved.getId());
        result.put("status", HttpStatus.CREATED);
        result.put("result", "SUCCESS");

        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO,"addUser is finishing in POST('/users') "+ time + " ms");
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

}
