package com.project.expenseTracker.User;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserjpaRepository userjpaRepo;

    @Override
    public UserResponseDTO register(UserDTO user) throws UserException {
        if(userjpaRepo.existsByName(user.getName())){
            throw new UserException("A user already exists with the name");
        }
        UserDTO savedUser = this.userjpaRepo.save(user);
        System.out.println(savedUser);
        return new UserResponseDTO(savedUser.getName(), savedUser.getId());
    }

    @Override
    public UserDTO login(UserLoginDto user) throws UserException{
        Optional<UserDTO> foundUser = this.userjpaRepo.findByName(user.getName());
        if(foundUser==null){
            throw new UserException("No such User");
        }
        if (foundUser.get().getName() == user.getName() ){
            if(foundUser.get().getPassword() != user.getPassword()){
                throw new UserException("Invalid Credential");
            }


        }
        return foundUser.get();
    }

    @Override
    public Collection<UserDTO> getall() {

        return this.userjpaRepo.findAll();
    }
}
