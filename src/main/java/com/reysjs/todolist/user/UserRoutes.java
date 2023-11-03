package com.reysjs.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserRoutes {

    @Autowired
    private UserController userController;

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserModel userModel) {

        return userController.create(userModel);
    }
}
