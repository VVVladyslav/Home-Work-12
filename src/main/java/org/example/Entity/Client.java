package org.example.Entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "CLIENT")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false, length = 200)
    private String name;
}
