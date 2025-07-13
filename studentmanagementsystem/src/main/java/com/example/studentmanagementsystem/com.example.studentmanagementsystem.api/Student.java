package com.example.studentmanagementsystem.com.example.studentmanagementsystem.api;

import jakarta.persistence.*;

@Entity
@Table(name ="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;
    @Column(name = "student_name")
    private String name;
    @Column
    private float percentage;
    @Column
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Student() {

    }

    public Student(int rollno, String name, float percentage, String branch) {
        this.rollno = rollno;
        this.name = name;
        this.percentage = percentage;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                ", branch='" + branch + '\'' +
                '}';
    }
}
