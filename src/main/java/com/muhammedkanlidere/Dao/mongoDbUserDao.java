package com.muhammedkanlidere.Dao;

import com.muhammedkanlidere.Entity.User;

import java.util.Collection;

public class mongoDbUserDao implements UserDao  {

    //TODO connect to mongodb
    @Override
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void insertUser(User user) {

    }
}
