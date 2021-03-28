package com.faresatoui.userprofileapps.demo.repository;

import com.faresatoui.userprofileapps.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that extends MongoRepository to get access to all mongo CRUD methods
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {

    /**
     * Find a user by login
     * @param login, String to find
     * @return User that match the login
     */
    User findUserByLogin(String login);
}
