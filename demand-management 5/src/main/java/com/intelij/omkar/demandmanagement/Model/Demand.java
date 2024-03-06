package com.intelij.omkar.demandmanagement.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Demands")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String projectName;

    private String managerName;

    public enum LevelChoice {
        A00, A01, A02, A03,
        AS1, AS2,
        P01, P02, P03, P04,
        PS1, PS2, PS3, PS4,
        M01, M02, M03,
        E01, E02, E03, E04,
        MS1, MS2,
        ES1, ES2
    }

    private String location;

    private float duration;

    public enum StatusChoice {
        OPEN, CLOSED
    }

    @Enumerated(EnumType.STRING)
    private StatusChoice status = StatusChoice.OPEN;

    @Enumerated(EnumType.STRING)
    private LevelChoice level;

    private Date startDate;

    @ElementCollection
    @Column(name = "skill")
    private List<String> skills = new ArrayList<>();

    public StatusChoice getStatus() {
        return status;
    }

    public LevelChoice getLevel() {
        return level;
    }

    public void setLevel(LevelChoice level) {
        this.level = level;
    }

    public void setStatus(StatusChoice status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = Date.valueOf(startDate);
    }

    public float getDuration() {
        return duration;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}