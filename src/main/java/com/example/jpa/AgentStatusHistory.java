package com.example.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agent_status_history")
@Data
public class AgentStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
