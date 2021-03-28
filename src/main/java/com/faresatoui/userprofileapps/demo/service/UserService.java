package com.faresatoui.userprofileapps.demo.service;

import com.faresatoui.userprofileapps.demo.model.User;
import com.faresatoui.userprofileapps.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that implements UserRepo to write body of methods
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Add user in database
     * @param user, user to insert
     * @return the user inserted
     */
    public User addAnUser(User user) {
        return userRepository.insert(user);
    }

    /**
     * Get user by login
     * @param login, field to find
     * @return a matched user
     */
    public User getUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

    /**
     * Get users with pagination
     * @param page, number of page
     * @param size, size of page
     * @return a List of users with pagination
     */
    public Map<String, Object> getUsersByPage(int page, int size) {
        Map<String,Object> result = new HashMap<>();
        Pageable pageable = PageRequest.of(page,size);
        Page<User> userPage = userRepository.findAll(pageable);
        result.put("data", userPage.getContent());
        result.put("Total_of_pages", userPage.getTotalPages());
        result.put("Total_of_elements", userPage.getTotalElements());
        result.put("Current_page", userPage.getNumber());
        return result;
    }
}
