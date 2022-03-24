package com.misho0501.datasources;

import com.misho0501.beans.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserList {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return new ArrayList<>(Arrays.asList(
                new User("User 1", "user", "pass"),
                new User("User 2", "user", "pass"),
                new User("User 3", "user", "pass"),
                new User("User 4", "user", "pass"),
                new User("User 5", "user", "pass"),
                new User("User 6", "user", "pass")
        ));
    }

    public void setUserBeans(ArrayList<User> userBeans) {
        this.users = userBeans;
    }
}
