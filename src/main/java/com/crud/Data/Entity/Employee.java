package com.crud.Data.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "EmployeeDetails")
public class Employee {

    @Id
    @GeneratedValue(generator = "seq_genrater",strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "seq_genrater" ,initialValue = 01,allocationSize = 1)
    private int id;

    @Column(length = 25,nullable = false)
    private String name;

    @Column(length = 25,nullable = false)
    private String department;

    @Column(length = 25,nullable = false)
    private String techknowledgy;

    @Column(nullable = false)
    private int salory;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTechknowledgy() {
        return techknowledgy;
    }

    public void setTechknowledgy(String techknowledgy) {
        this.techknowledgy = techknowledgy;
    }

    public int getSalory() {
        return salory;
    }

    public void setSalory(int salory) {
        this.salory = salory;
    }
}
