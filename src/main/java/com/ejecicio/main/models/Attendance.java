package com.ejecicio.main.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AttendanceId;
    private Date date;
    private boolean attended;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;


    public Attendance() {
    }

    public Attendance(int AttendanceId, Date date, boolean attended, Employee employee) {
        this.AttendanceId = AttendanceId;
        this.date = date;
        this.attended = attended;
        this.employee = employee;
    }

    public int getAttendanceId() {
        return this.AttendanceId;
    }

    public void setAttendanceId(int AttendanceId) {
        this.AttendanceId = AttendanceId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttended() {
        return this.attended;
    }

    public boolean getAttended() {
        return this.attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Attendance AttendanceId(int AttendanceId) {
        setAttendanceId(AttendanceId);
        return this;
    }

    public Attendance date(Date date) {
        setDate(date);
        return this;
    }

    public Attendance attended(boolean attended) {
        setAttended(attended);
        return this;
    }

    public Attendance employee(Employee employee) {
        setEmployee(employee);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Attendance)) {
            return false;
        }
        Attendance attendance = (Attendance) o;
        return AttendanceId == attendance.AttendanceId && Objects.equals(date, attendance.date) && attended == attendance.attended && Objects.equals(employee, attendance.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AttendanceId, date, attended, employee);
    }

    @Override
    public String toString() {
        return "{" +
            " AttendanceId='" + getAttendanceId() + "'" +
            ", date='" + getDate() + "'" +
            ", attended='" + isAttended() + "'" +
            ", employee='" + getEmployee() + "'" +
            "}";
    }


}
