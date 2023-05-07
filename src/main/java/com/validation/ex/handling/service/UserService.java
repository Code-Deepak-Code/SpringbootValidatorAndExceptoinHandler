package com.validation.ex.handling.service;

import com.validation.ex.handling.dto.UserRequest;
import com.validation.ex.handling.entity.User;
import com.validation.ex.handling.exception.UserNotFoundExcetption;
import com.validation.ex.handling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0,userRequest.getName(),
                userRequest.getEmail(), userRequest.getMobile(),
                userRequest.getGender(), userRequest.getAge(),
                userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundExcetption {
        final User byUserId = userRepository.findByUserId(id);

        if (byUserId != null) {
            return byUserId;
        } else {
            throw new UserNotFoundExcetption("user not found with id :"+ id);
        }
    }


}
