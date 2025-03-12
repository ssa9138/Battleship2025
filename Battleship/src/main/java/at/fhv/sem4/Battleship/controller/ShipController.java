package at.fhv.sem4.Battleship.controller;

import at.fhv.sem4.Battleship.model.Ship;
import at.fhv.sem4.Battleship.service.ShipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games/{gameId}/ships")
public class ShipController {
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping
    public ResponseEntity<Ship> placeShip(
            @PathVariable Long gameId,
            @RequestParam Long playerId,
            @RequestParam int x,
            @RequestParam int y,
            @RequestParam int length,
            @RequestParam String direction) {

        Ship ship = shipService.placeShip(gameId, playerId, x, y, length, direction);
        return ResponseEntity.ok(ship);
    }
}
