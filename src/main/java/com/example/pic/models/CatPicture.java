package com.example.pic.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name ;
    public String age;
    public String img;

    public CatPicture() {

    }

    public CatPicture(String name, String age,String img) {
        this.name = name;
        this.age = age;
        this.img = img;
    }

    public long getId() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "CatPicture{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
