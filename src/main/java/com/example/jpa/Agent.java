package com.example.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="agent")
@Data
public class Agent {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String username;

    private Integer age;
}
