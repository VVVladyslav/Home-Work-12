package org.example.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TICKET")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet from_planet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet to_planet;
}