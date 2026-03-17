package com.enterprise.ecommerce.service;

import org.springframework.stereotype.Service;
import com.enterprise.ecommerce.entity.User;
import com.enterprise.ecommerce.repository.UserRepository;
import com.enterprise.ecommerce.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
