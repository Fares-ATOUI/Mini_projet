package com.faresatoui.userprofileapps.demo;

import com.faresatoui.userprofileapps.demo.model.Address;
import com.faresatoui.userprofileapps.demo.model.User;
import com.faresatoui.userprofileapps.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to start application and implement CommandLineRunner to save somme data
 */
@SpringBootApplication
public class UserProfileApps implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(UserProfileApps.class, args);
    }

    @Override
    public void run(String... args) {
        /**
         * List of users
         */
        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User("Jean","LUC", "aaaa", LocalDate.of(2000,1,1), new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a designer"));
        listUsers.add(new User("Julie","BREFFA", "bbbb", LocalDate.of(2001,2,2),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a designer"));
        listUsers.add(new User("Jemal","AUDO", "ccccc", LocalDate.of(2002,3,3),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a comedian"));
        listUsers.add(new User("Soli","MAN", "dddd4", LocalDate.of(2001,4,4),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a superhero"));
        listUsers.add(new User("Jean","JACK", "eeee", LocalDate.of(1999,5,5),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a singer"));
        listUsers.add(new User("Alfonso","BERDITCH", "ffff", LocalDate.of(2002,6,6),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a tenisman"));
        listUsers.add(new User("Abdel","BOUTEF", "gggg", LocalDate.of(1993,7,7),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a president"));
        listUsers.add(new User("Riyad","MAHREZ", "hhhh", LocalDate.of(1998,8,8),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a football player"));
        listUsers.add(new User("Karim","BENZEMA", "iiiii", LocalDate.of(2002,9,9),new Address("2400 route des dolines","valbonne","france",06560),"may bio i am a football plater"));
        listUsers.add(new User("Fred","MUZZA", "jjjjj", LocalDate.of(2001,10,10),new Address("2400 route des dolines","valbonne","france",06560),"my bio i am a journalist"));

        userRepository.deleteAll();
        userRepository.insert(listUsers);
    }
}
