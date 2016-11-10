package com.users.controller;

import java.util.List;

import com.users.domain.User;
import com.users.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createAccount")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(
            method = RequestMethod.POST,
            headers="Accept=application/json",
            produces="application/json"
    )
    public User  createAccount(@RequestBody User userParams) {
        return usersService.save(userParams);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            headers="Accept=application/json",
            produces="application/json"
    )
    public List getAllUSer() {
        return usersService.get();

    }

}
