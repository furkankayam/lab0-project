package com.furkankayam.lab0project.controller;

import com.furkankayam.lab0project.dto.request.UserRequest;
import com.furkankayam.lab0project.dto.response.UserResponse;
import com.furkankayam.lab0project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //LIST
    //http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //CREATE
    //http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    //UPDATE
    //http://localhost:8080/api/users/{uuid}
    @PutMapping("/update/{uuid}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID uuid,
                                                   @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(uuid,userRequest), HttpStatus.OK);
    }

    //DELETE
    //http://localhost:8080/api/users/{uuid}
    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable UUID uuid) {
        return new ResponseEntity<>(userService.deleteUser(uuid), HttpStatus.OK);
    }

    //FIND
    //http://localhost:8080/api/users/{name}
    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> getByUser(@PathVariable UUID uuid) {
        return new ResponseEntity<>(userService.getById(uuid), HttpStatus.OK);
    }


}
