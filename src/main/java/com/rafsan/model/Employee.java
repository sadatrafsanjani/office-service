package com.rafsan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    @JsonProperty("department")
    private Department department;

    @Column(name = "NAME", length = 30)
    @JsonProperty("name")
    private String name;

    @Column(name = "PHOTO", length = 30)
    @JsonProperty("photo")
    private String photo;

    @Column(name = "JOINING_DATE")
    @JsonProperty("joiningDate")
    private String joiningDate;

    @Column(name = "DATE_OF_BIRTH")
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @Column(name = "DESIGNATION", length = 20)
    @JsonProperty("designation")
    private String designation;

    @Column(name = "BASIC_SALARY")
    @JsonProperty("basicSalary")
    private double basicSalary;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    @JsonProperty("gender")
    private Gender gender;
}
