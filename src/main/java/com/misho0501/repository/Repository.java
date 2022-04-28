package com.misho0501.repository;

import com.misho0501.beans.User;
import com.misho0501.datasources.UserList;

import java.util.HashSet;

public class Repository {
    private static Repository instance = null;

    HashSet<User> users;
    static int index = 0;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
        users = new HashSet<>(new UserList().getUsers());
    }

    public boolean hasExist(String username) {
        return users.contains(new User(username));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if(user.equals(new User(username))) {
                return user;
            }
        }
        return null;
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
