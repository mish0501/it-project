package com.misho0501.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Comparable<Skill> {
    private String name;
    private float percent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Float.compare(skill.percent, percent) == 0 && name.equals(skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percent);
    }

    @Override
    public int compareTo(Skill o) {
        return o.name.compareTo(this.name);
    }
}
