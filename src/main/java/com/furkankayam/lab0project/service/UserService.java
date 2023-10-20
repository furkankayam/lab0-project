package com.furkankayam.lab0project.service;

import com.furkankayam.lab0project.dto.request.UserRequest;
import com.furkankayam.lab0project.dto.response.UserResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {

    //CREATE
    UserResponse createUser(UserRequest userRequest);

    //UPDATE
    UserResponse updateUser(UUID uuid, UserRequest userRequest);

    //FIND
    UserResponse getById(UUID uuid);

    //DELETE
    Map<String, Boolean> deleteUser(UUID uuid);

    //LIST
    List<UserResponse> getAllUsers();

}
