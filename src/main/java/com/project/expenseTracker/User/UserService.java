package com.project.expenseTracker.User;

import java.util.Collection;

public interface UserService {

    UserResponseDTO register(UserDTO user) throws UserException;

    UserDTO login(UserLoginDto user) throws  UserException;

    Collection<UserDTO> getall();
}
