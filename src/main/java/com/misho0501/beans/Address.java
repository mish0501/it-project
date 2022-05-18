package com.misho0501.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;

    public void update(String street, String city) {
        this.street = street;
        this.city = city;
    }

}
