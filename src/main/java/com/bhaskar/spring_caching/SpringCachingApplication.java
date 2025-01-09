package com.bhaskar.spring_caching;

import com.bhaskar.spring_caching.entity.MyUser;
import com.bhaskar.spring_caching.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

@SpringBootApplication
@EnableCaching
public class SpringCachingApplication {

//    @Autowired
//    private UserRepository userRepository;

//    public void initUsers() {
//        List<MyUser> users = Stream.of(
//                new MyUser(100, "bhaskar", "password", "user1@gmail.com"),
//                new MyUser(101, "rajesh", "password", "user2@gmail.com")
//                ).collect(Collectors.toList());
//
//        userRepository.saveAll(users);
//    }


    public static void main(String[] args) {

		SpringApplication.run(SpringCachingApplication.class, args);
    }

}
