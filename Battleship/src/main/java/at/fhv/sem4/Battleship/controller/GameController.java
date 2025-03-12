package at.fhv.sem4.Battleship.controller;

import at.fhv.sem4.Battleship.dto.GameStatusDTO;
import at.fhv.sem4.Battleship.service.GameService;

import at.fhv.sem4.Battleship.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> createGame() {
        return ResponseEntity.ok(gameService.createGame());
    }
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameStatusDTO> getGameStatus(@PathVariable Long gameId) {
        return ResponseEntity.ok(gameService.getGameStatus(gameId));
    }
}
