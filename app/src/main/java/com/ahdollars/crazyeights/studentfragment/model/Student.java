package com.ahdollars.crazyeights.studentfragment.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Shashank on 02-09-2016.
 */
public class Student {

    public static ArrayList<Student> items=new ArrayList<>();

    public String name;
    public int age;
    public int roll;
    public  String address;
    public String sex;
    public  Bitmap photo;

    public Student(String address, int age, String name, Bitmap photo, String sex, int roll) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.photo = photo;
        this.sex = sex;
        this.roll = roll;
    }




}
