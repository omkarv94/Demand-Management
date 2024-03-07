package com.intelij.omkar.demandmanagement.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String eid;

    private String firstName;

    private String lastName;

    private Date doj;

    private enum LevelChoices {
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

    private float overallExp;

    public enum StatusChoice {
        AVAILABLE, ASSIGNED
    }
    @Enumerated(EnumType.STRING)
    private StatusChoice status = StatusChoice.AVAILABLE;

    @Enumerated(EnumType.STRING)
    private LevelChoices level;

    @Convert(converter = SkillsConverter.class)
    private Map<String, Integer> skills = new HashMap<>();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public StatusChoice getStatus() {
        return status;
    }

    @Column
    public void setStatus(StatusChoice status) {
        this.status = status;
    }

    public LevelChoices getLevel() {
        return level;
    }

    public void setLevel(LevelChoices level) {
        this.level = level;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Integer> skills) {
        this.skills = skills;
    }

    @Converter
    public static class SkillsConverter implements AttributeConverter<Map<String, Integer>, String> {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public String convertToDatabaseColumn(Map<String, Integer> attribute) {
            if (attribute == null || attribute.isEmpty()) {
                return null;
            }
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (IOException e) {
                throw new IllegalArgumentException("Error converting map to JSON", e);
            }
        }

        @Override
        public Map<String, Integer> convertToEntityAttribute(String dbData) {
            if (dbData == null || dbData.isEmpty()) {
                return new HashMap<>();
            }
            try {
                return objectMapper.readValue(dbData, new TypeReference<Map<String, Integer>>() {
                });
            } catch (IOException e) {
                throw new IllegalArgumentException("Error converting JSON to map", e);
            }
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        String str = doj;
        Date date = Date.valueOf(str);
        this.doj = date;
    }

    public float getOverallExp() {
        return overallExp;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }


    public String getEid() {
        return eid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOverallExp(float overallExp) {
        this.overallExp = overallExp;
    }

}
