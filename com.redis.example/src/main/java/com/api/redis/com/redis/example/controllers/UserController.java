package com.api.redis.com.redis.example.controllers;

import com.api.redis.com.redis.example.doa.UserDao;
import com.api.redis.com.redis.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping()
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
    return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userID){
        return userDao.get(userID);
    }

    @GetMapping
    public List<User> getAll(){
        Map<Object,Object> all =userDao.findAll();

        Collection<Object> values = all.values();
        List<User> collect = values.stream().map(value->(User)value).collect(Collectors.toList());
        return collect;
    }
@DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userDao.delete(userId);
    }

}

