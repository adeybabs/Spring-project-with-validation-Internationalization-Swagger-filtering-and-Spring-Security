package com.user.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;


    //GET  /users
    //retrieveAllUsers
    @GetMapping("jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    //GET   /users/{id}
    //retrieveUser(int id)
    @GetMapping("jpa/users/{id}")
    public User retrieveUser(@PathVariable int id){
        final User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-" + id);
        return user;
    }

    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if(user == null)
            throw new UserNotFoundException("id-" + id);
    }


    //create a new user
    //input-details of user
    //output- msg -user created
    @PostMapping("jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        //status when created
        // /user/{id}  savedUser.getId()
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}

