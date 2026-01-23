package org.fhnw.sport.sportclub.Pet;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    //@GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private double age;

    public Pet() {
    }
    public Pet(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
