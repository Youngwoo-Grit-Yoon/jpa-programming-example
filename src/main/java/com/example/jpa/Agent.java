package com.example.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="agent", uniqueConstraints = {
        @UniqueConstraint(
                name = "name_age_unique",
                columnNames = {"name", "age"}
        )
})
@Data
public class Agent {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name", nullable = false, length = 10)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
