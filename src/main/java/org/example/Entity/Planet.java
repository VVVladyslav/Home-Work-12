package org.example.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLANET")

    public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name",nullable = false, length = 500)
    private String name;
}