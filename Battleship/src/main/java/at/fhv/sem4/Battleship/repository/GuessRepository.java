package at.fhv.sem4.Battleship.repository;

import at.fhv.sem4.Battleship.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Guess, Long> {
}
