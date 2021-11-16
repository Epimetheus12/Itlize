package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.User;
import com.itlize.backend.demo.repositories.UserRepository;
import com.itlize.backend.demo.services.UserService;
import com.itlize.backend.demo.utils.dto.UserDto;
import com.itlize.backend.demo.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional <User> findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User findOneById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll( ) {
        return userRepository.findAll();
    }

    @Override
    public User updateOneById(UserDto dto) {
        User user = userRepository.findById(dto.getId()).orElse(null);
        mapper.updateUserFromDto(dto, user);
        assert user != null;
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteOneById(int id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }
}
