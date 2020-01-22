package com.rafsan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @Column(name = "DEPARTMENT_CODE", length = 5)
    @JsonProperty("departmentCode")
    private String departmentCode;

    @Column(name = "NAME", length = 30)
    @JsonProperty("name")
    private String name;

    @Column(name = "ACTIVE")
    @JsonProperty("active")
    private boolean active;

}
