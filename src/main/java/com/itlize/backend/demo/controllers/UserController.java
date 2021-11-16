package com.itlize.backend.demo.controllers;

import com.itlize.backend.demo.entities.User;
import com.itlize.backend.demo.services.ProjectService;
import com.itlize.backend.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public UserController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUserByUserId() {
        return new ResponseEntity< >(userService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<?> userById(@RequestParam("id") int id) {
        return new ResponseEntity< >(userService.findOneById(id), HttpStatus.OK);
    }

    @GetMapping("/delete/")
    public ResponseEntity<?> deleteById(@RequestParam("id") int id){
        return new ResponseEntity< >(userService.deleteOneById(id), HttpStatus.OK);
    }

    @GetMapping("/update/")
    public ResponseEntity<?> updateById(@RequestParam("id") int id,
                                        @RequestParam("username") String username,
                                        @RequestParam("email") String email) {
        UserDto dto = new UserDto();
        dto.setUpdatedTime(new Timestamp(new Date().getTime()));
        dto.setId(id);
        dto.setUsername(username);
        dto.setEmail(email);
        return new ResponseEntity<>(userService.updateOneById(dto), HttpStatus.OK);
    }

    @GetMapping("/create/")
    public ResponseEntity<?> createOne(@RequestParam("id") int id,
                                       @RequestParam("username") String username,
                                       @RequestParam("email") String email) {
        User u = new User();
        u.setCreatedTime(new Timestamp(new Date().getTime()));
        u.setUsername(username);
        u.setEmail(email);
        return new ResponseEntity<>(userService.createOne(u), HttpStatus.CREATED);
    }

    @GetMapping("/addResource") // Need to work on this part
    public ResponseEntity<?> addResource(@RequestParam("uid") int pid,
                                         @RequestParam("pid") int uid){
        return new ResponseEntity<>(userService.updateRelationship(pid, uid),HttpStatus.CREATED); //Need to fix this
    }

}