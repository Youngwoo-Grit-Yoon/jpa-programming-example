package com.example.jpa.examples.practice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "order_id")
    private Long orderId;

    private int orderPrice;
    private int count;
}
