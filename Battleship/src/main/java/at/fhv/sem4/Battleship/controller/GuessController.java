package at.fhv.sem4.Battleship.controller;

import at.fhv.sem4.Battleship.model.Guess;
import at.fhv.sem4.Battleship.service.GuessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games/{gameId}/guess")
public class GuessController {
    private final GuessService guessService;

    public GuessController(GuessService guessService) {
        this.guessService = guessService;
    }

    @PostMapping
    public ResponseEntity<Guess> makeGuess(
            @PathVariable Long gameId,
            @RequestParam Long playerId,
            @RequestParam int x,
            @RequestParam int y) {

        Guess guess = guessService.makeGuess(gameId, playerId, x, y);
        return ResponseEntity.ok(guess);
    }
}
