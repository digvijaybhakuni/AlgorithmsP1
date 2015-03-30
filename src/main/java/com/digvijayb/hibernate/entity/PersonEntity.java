package com.digvijayb.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by digvijayb on 29/3/15.
 */
@Entity
@Table(name = "Person")
public class PersonEntity implements java.io.Serializable {


    private int id;
    private String name;
    private int age;

    public PersonEntity(){}

    public PersonEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
