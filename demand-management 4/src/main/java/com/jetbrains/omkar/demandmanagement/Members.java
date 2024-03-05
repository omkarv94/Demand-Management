package com.jetbrains.omkar.demandmanagement;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Memberss")
public class Members {

    private long id;
    private long eid;
    private String first_Name;
    private String last_Name;
    private String date_of_joining;
    private int level;
    private String location;
    private int overall_exp;
    private String status;

    Map<String,Integer> m = new HashMap<>();
    public Members() {

    }

    public Members(String first_Name, String last_Name, String emailId) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getfirst_Name() {
        return first_Name;
    }
    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    @Column(name = "last_name", nullable = false)
    public String getlast_Name() {
        return last_Name;
    }
    public void setlast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    @Column(name = "date_of_joining", nullable = false)
    public String getdate_of_joining() {
        return date_of_joining;
    }
    public void setdate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    @Column(name = "location", nullable = false)
    public String getlocation() {
        return location;
    }
    public void setlocation(String location) {
        this.location = location;
    }

    @Column(name = "level", nullable = false)
    public int getlevel() {
        return level;
    }
    public void setlevel(int level) {
        this.level = level;
    }

    @Column(name = "overall_exp", nullable = false)
    public int getoverall_exp() {
        return overall_exp;
    }
    public void setoverall_exp(int overall_exp) {
        this.level = overall_exp;
    }

    @Column(name = "status", nullable = false)
    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }

    @Column(name = "skills", nullable = false)
    public Map getskills() {
        return m;
    }
    public void setskills(String skill,int exp) {

        m.put(skill,exp);
    }

    @Override
    public String toString() {
        return "Members [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", date_of_joining=" + date_of_joining + ", location=" + location + ", overall_exp=" + overall_exp + ", status="+status +", skils=" + m.getKey() +"-"+m.getValue();
                + "]";
    }
}
