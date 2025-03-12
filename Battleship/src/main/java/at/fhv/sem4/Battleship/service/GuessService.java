package at.fhv.sem4.Battleship.service;

import at.fhv.sem4.Battleship.model.Game;
import at.fhv.sem4.Battleship.model.Guess;
import at.fhv.sem4.Battleship.model.Player;
import at.fhv.sem4.Battleship.model.Ship;
import at.fhv.sem4.Battleship.repository.GameRepository;
import at.fhv.sem4.Battleship.repository.GuessRepository;
import at.fhv.sem4.Battleship.repository.PlayerRepository;
import at.fhv.sem4.Battleship.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuessService {
    private final GuessRepository guessRepository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final ShipRepository shipRepository;

    public GuessService(GuessRepository guessRepository, GameRepository gameRepository, PlayerRepository playerRepository, ShipRepository shipRepository) {
        this.guessRepository = guessRepository;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.shipRepository = shipRepository;
    }

    public Guess makeGuess(Long gameId, Long playerId, int x, int y) {
        System.out.println("📌 Checking gameId: " + gameId);
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isEmpty()) {
            System.err.println("🚨 Game NOT found: " + gameId);
            throw new IllegalArgumentException("Game not found");
        }

        System.out.println("📌 Checking playerId: " + playerId);
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            System.err.println("🚨 Player NOT found: " + playerId);
            throw new IllegalArgumentException("Player not found");
        }

        // Prüfen, ob die Koordinaten ein Schiff treffen
        boolean hit = shipRepository.findAll().stream().anyMatch(ship -> {
            if (ship.getGame().getId().equals(gameId)) {
                if (ship.getDirection().equals("HORIZONTAL")) {
                    return x >= ship.getX() && x < ship.getX() + ship.getLength() && y == ship.getY();
                } else {
                    return y >= ship.getY() && y < ship.getY() + ship.getLength() && x == ship.getX();
                }
            }
            return false;
        });

        Guess guess = new Guess();
        guess.setGame(game.get());
        guess.setPlayer(player.get());
        guess.setX(x);
        guess.setY(y);
        guess.setHit(hit);

        return guessRepository.save(guess);
    }
}
