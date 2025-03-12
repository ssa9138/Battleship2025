package at.fhv.sem4.Battleship.repository;

import at.fhv.sem4.Battleship.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
