package com.misho0501.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String username;
    private String photo;
    private String password;
    private String description;
    private String job;
    private String location;
    private String phone;
    private String email;
    private ArrayList<Skill> skills;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
//        return name.equals(user.name) && username.equals(user.username) && Objects.equals(photo, user.photo) && password.equals(user.password) && Objects.equals(description, user.description) && Objects.equals(job, user.job) && Objects.equals(location, user.location) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(skills, user.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
