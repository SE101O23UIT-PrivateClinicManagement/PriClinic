package com.SE330.Demo.Service;

import com.SE330.Demo.Model.User;
import com.SE330.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User newUser) {
        if(newUser!=null){
            return userRepository.save(newUser);
        }
        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        if(user!=null){
            //User user1 = getUser(id);
            //if(user1!=null){
                //updating here
            //}
        }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        if(id>=1){
            Optional<User> user = getUser(id);
            if(user.isPresent()){
                userRepository.delete(user.get());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }
}
