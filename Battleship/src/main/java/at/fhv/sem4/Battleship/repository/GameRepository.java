package at.fhv.sem4.Battleship.repository;

import at.fhv.sem4.Battleship.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
