package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.User;

import java.util.List;

public interface UserService {

    public List<User> initData( );
    public User findOneById(int id);
    public List<User> findAll( );

    public User createOne(User user);


    public User updateOneById(UserDto dto);

    public Boolean deleteOneById(int id);
}
