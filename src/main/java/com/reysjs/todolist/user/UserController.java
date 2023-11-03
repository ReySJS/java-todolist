package com.reysjs.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserController {

    @Autowired
    public IUserRepository userRepository;

    public ResponseEntity create(UserModel userModel) {

        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already registered user");
        }

        var createdUser = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
