package com.javastudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private short age;
    private short gender;
    private String phone;

/*    public User() {
    }

    public User(Integer id, String name, short age, short gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    *//**
     * 获取
     * @return id
     *//*
    public Integer getId() {
        return id;
    }

    *//**
     * 设置
     * @param id
     *//*
    public void setId(Integer id) {
        this.id = id;
    }

    *//**
     * 获取
     * @return name
     *//*
    public String getName() {
        return name;
    }

    *//**
     * 设置
     * @param name
     *//*
    public void setName(String name) {
        this.name = name;
    }

    *//**
     * 获取
     * @return age
     *//*
    public short getAge() {
        return age;
    }

    *//**
     * 设置
     * @param age
     *//*
    public void setAge(short age) {
        this.age = age;
    }

    *//**
     * 获取
     * @return gender
     *//*
    public short getGender() {
        return gender;
    }

    *//**
     * 设置
     * @param gender
     *//*
    public void setGender(short gender) {
        this.gender = gender;
    }

    *//**
     * 获取
     * @return phone
     *//*
    public String getPhone() {
        return phone;
    }

    *//**
     * 设置
     * @param phone
     *//*
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "User{id = " + id + ", name = " + name + ", age = " + age + ", gender = " + gender + ", phone = " + phone + "}";
    }*/
}
