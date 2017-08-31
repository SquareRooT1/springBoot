package com.muhammedkanlidere.Dao;

import com.muhammedkanlidere.Entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUsers();

    User getUserById(int id);

    void removeStudentById(int id);

    void updateUser(User user);

    void insertUser(User user);
}
