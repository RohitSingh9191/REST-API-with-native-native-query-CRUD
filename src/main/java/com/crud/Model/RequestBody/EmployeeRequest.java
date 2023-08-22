package com.crud.Model.RequestBody;


public class EmployeeRequest {
    private String name;
    private String department;
    private String techknowledgy;
    private int salory;

    public EmployeeRequest(String name, String department, String techknowledgy, int salory) {
        this.name = name;
        this.department = department;
        this.techknowledgy = techknowledgy;
        this.salory = salory;
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
