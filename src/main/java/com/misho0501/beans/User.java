package com.misho0501.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
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
    private Address location;
    private String phone;
    private String email;
    private List<Skill> jobSkills = new ArrayList<Skill>() {{
        add(new Skill("JavaScript", 0));
        add(new Skill("PHP", 0));
        add(new Skill("HTML", 0));
        add(new Skill("CSS", 0));
        add(new Skill("Java", 0));
        add(new Skill("C++", 0));
        add(new Skill("C#", 0));
    }};

    private List<Skill> personalSkills = new ArrayList<Skill>() {{
        add(new Skill("Комуникативност", 0));
        add(new Skill("Екипна работа", 0));
        add(new Skill("Креативност", 0));
    }};

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public void addJobSkill(Skill job) {
        jobSkills.add(job);
    }

    public void removeJobSkill(Skill job) {
        jobSkills.remove(job);
    }

    public void addPersonalSkills(Skill personalSkill) {
        personalSkills.add(personalSkill);
    }

    public void removePersonalSkills(Skill personalSkill) {
        personalSkills.remove(personalSkill);
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
