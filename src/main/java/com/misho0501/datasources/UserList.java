package com.misho0501.datasources;

import com.misho0501.beans.Address;
import com.misho0501.beans.Skill;
import com.misho0501.beans.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserList {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        ArrayList<Skill> jobSkills = new ArrayList<Skill>() {{
            add(new Skill("JavaScript", 75));
            add(new Skill("PHP", 80));
            add(new Skill("HTML", 95));
            add(new Skill("CSS", 80));
            add(new Skill("Java", 60));
            add(new Skill("C++", 50));
            add(new Skill("C#", 45));
        }};

        ArrayList<Skill> personalSkills = new ArrayList<Skill>() {{
            add(new Skill("Комуникативност", 85));
            add(new Skill("Екипна работа", 95));
            add(new Skill("Креативност", 50));
        }};

        return new ArrayList<>(Arrays.asList(
                new User(
                        "User 1",
                        "user",
                        null,
                        "pass",
                        "asdasd",
                        "Test job",
                        new Address("Test street", "Test city"),
                        "0892758258",
                        "email",
                        jobSkills,
                        personalSkills
                ),
                new User(
                        "User 2",
                        "user1",
                        null,
                        "pass",
                        "asdasd",
                        "Test job",
                        new Address("Test street", "Test city"),
                        "0892758258",
                        "email",
                        jobSkills,
                        personalSkills
                ),
                new User(
                        "User 3",
                        "user2",
                        null,
                        "pass",
                        "asdasd",
                        "Test job",
                        new Address("Test street", "Test city"),
                        "0892758258",
                        "email",
                        jobSkills,
                        personalSkills
                )
        ));
    }

    public void setUserBeans(ArrayList<User> userBeans) {
        this.users = userBeans;
    }
}
