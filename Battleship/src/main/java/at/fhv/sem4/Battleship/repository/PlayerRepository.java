package at.fhv.sem4.Battleship.repository;

import at.fhv.sem4.Battleship.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
