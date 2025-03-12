package at.fhv.sem4.Battleship.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Player player;

    private int x;
    private int y;
    private int length;
    private String direction; // "HORIZONTAL" oder "VERTICAL"
}
