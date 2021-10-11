package com.user.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 5;

    static {
        users.add(new User(1,"David", new Date()));
        users.add(new User(2,"James", new Date()));
        users.add(new User(3,"King", new Date()));
        users.add(new User(4,"Queen", new Date()));
        users.add(new User(5,"Freya", new Date()));

    }

    //method for findAll()
    public List<User> findAll(){
        return users;
    }

    //method for saving users
    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    //method for finding A student
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}