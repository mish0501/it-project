package com.misho0501.datasources;

import com.misho0501.beans.Address;
import com.misho0501.beans.Skill;
import com.misho0501.beans.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserList {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return new ArrayList<>(Arrays.asList(
                new User("User 1", "user", null, "pass", "asdasd", "Test job", new Address("Test street", "Test city"), "0892758258", "email", new ArrayList<Skill>() {{
                    add(new Skill("JavaScript", 75));
                    add(new Skill("PHP", 80));
                    add(new Skill("HTML", 95));
                    add(new Skill("CSS", 80));
                    add(new Skill("Java", 60));
                    add(new Skill("C++", 50));
                    add(new Skill("C#", 45));
                }}, new ArrayList<Skill>() {{
                    add(new Skill("Комуникативност", 85));
                    add(new Skill("Екипна работа", 95));
                    add(new Skill("Креативност", 50));
                }}),
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
