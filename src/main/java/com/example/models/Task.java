package com.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;
}
