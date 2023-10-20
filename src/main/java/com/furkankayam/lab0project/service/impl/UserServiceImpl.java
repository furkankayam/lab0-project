package com.furkankayam.lab0project.service.impl;

import com.furkankayam.lab0project.dto.converter.UserConverterKt;
import com.furkankayam.lab0project.dto.request.UserRequest;
import com.furkankayam.lab0project.dto.response.UserResponse;
import com.furkankayam.lab0project.exception.UserNotFoundException;
import com.furkankayam.lab0project.model.User;
import com.furkankayam.lab0project.repository.UserRepository;
import com.furkankayam.lab0project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //IS-THERE-USER
    private User isThereUser(UUID uuid) {
        return userRepository
                .findById(uuid)
                .orElseThrow(
                        () -> new UserNotFoundException("User Not Found UUID: " + uuid)
                );
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = UserConverterKt.toUser(userRequest);
        userRepository.save(user);
        return UserConverterKt
                .toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UUID uuid, UserRequest userRequest) {
        User user = isThereUser(uuid);
        User userNew = new User(
                user.getId(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getPhoneNumber(),
                userRequest.getPassword(),
                userRequest.getEmail(),
                userRequest.getAddress()
        );
        userRepository.save(userNew);
        return UserConverterKt.toUserResponse(userNew);
    }

    @Override
    public UserResponse getById(UUID uuid) {
        User user = isThereUser(uuid);
        return UserConverterKt.toUserResponse(user);
    }

    @Override
    public Map<String, Boolean> deleteUser(UUID uuid) {
        Map<String, Boolean> response = new HashMap<>();
        userRepository.delete(isThereUser(uuid));
        response.put("Delete: ", Boolean.TRUE);
        return response;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList
                .stream()
                .map(temp -> UserConverterKt.toUserResponse(temp))
                .collect(Collectors.toList());
    }
}
