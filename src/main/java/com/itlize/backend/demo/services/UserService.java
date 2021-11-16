package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.User;
import com.itlize.backend.demo.utils.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User createOne(User user);
    Optional<User> findUserByUsername(String username);
    User findOneById(int id);
    List<User> findAll( );



    User updateOneById(UserDto dto);

    Boolean deleteOneById(int id);
}
