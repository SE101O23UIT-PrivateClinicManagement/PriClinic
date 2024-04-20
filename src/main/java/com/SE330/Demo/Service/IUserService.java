package com.SE330.Demo.Service;

import com.SE330.Demo.Model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User addUser(User newUser);
    public User updateUser(int id, User user);
    public boolean deleteUser(int id);
    public List<User> getAllUser();
    public Optional<User> getUser(int id);
}
