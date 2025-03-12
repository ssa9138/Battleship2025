package at.fhv.sem4.Battleship.dto;

import at.fhv.sem4.Battleship.model.Guess;
import at.fhv.sem4.Battleship.model.Ship;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameStatusDTO {
    private Long gameId;
    private boolean active;
    private List<Ship> ships;
    private List<Guess> guesses;
}
