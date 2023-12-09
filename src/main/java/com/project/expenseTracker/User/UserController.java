package com.project.expenseTracker.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String greet(){
        return "Hello World";
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserResponseDTO adduser(@Valid @RequestBody UserDTO user) throws UserException{
        return this.userservice.register(user);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody UserLoginDto user) throws UserException{
        return this.userservice.login(user);
    }

    @GetMapping("/users")
    public Collection<UserDTO> getAllWallets(){
        return this.userservice.getall();
    }





}
