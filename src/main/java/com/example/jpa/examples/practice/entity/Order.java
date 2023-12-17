package com.example.jpa.examples.practice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(name = "member_id")
    private long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

enum OrderStatus {
    ORDER, CANCEL;
}