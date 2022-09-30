package com.ejecicio.main.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {


    public Employee() {
    }

    public Employee(int id, String name, String lastName, List<Attendance> attendance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.attendance = attendance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Attendance> getAttendance() {
        return this.attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

    public Employee id(int id) {
        setId(id);
        return this;
    }

    public Employee name(String name) {
        setName(name);
        return this;
    }

    public Employee lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Employee attendance(List<Attendance> attendance) {
        setAttendance(attendance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(attendance, employee.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, attendance);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", attendance='" + getAttendance() + "'" +
            "}";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Attendance> attendance;
    
}
