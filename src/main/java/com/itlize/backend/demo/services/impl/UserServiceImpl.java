package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.User;
import com.itlize.backend.demo.repositories.UserRepository;
import com.itlize.backend.demo.services.UserService;
import com.itlize.backend.demo.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public List<User> initData( ) {
        User r1 = new User();
        User r2 = new User();

        r1.setUsername("r1");
        r1.setPhone("1");
        r1.setCreatedTime(new Timestamp(new Date().getTime()));

        r2.setUsername("r2");
        r2.setPhone("2");
        r2.setCreatedTime(new Timestamp(new Date().getTime()));

        r1 = userRepository.save(r1);
        r2 = userRepository.save(r2);
        return userRepository.findAllById(Arrays.asList(r1.getId(), r2.getId()));
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
    public User createOne(User user) {
        return userRepository.save(user);
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