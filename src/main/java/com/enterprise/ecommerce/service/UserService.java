package com.enterprise.ecommerce.service;

import org.springframework.stereotype.Service;
import com.enterprise.ecommerce.entity.User;
import com.enterprise.ecommerce.repository.UserRepository;
import com.enterprise.ecommerce.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<UserDTO> getAllUsers(){

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(u -> new UserDTO(
                        u.getId(),
                        u.getName(),
                        u.getEmail()
                ))
                .collect(Collectors.toList());
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
