package com.misho0501.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

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
}
