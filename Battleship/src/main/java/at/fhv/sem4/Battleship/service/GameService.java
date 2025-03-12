package at.fhv.sem4.Battleship.service;

import at.fhv.sem4.Battleship.dto.GameStatusDTO;
import at.fhv.sem4.Battleship.model.Game;
import at.fhv.sem4.Battleship.model.Guess;
import at.fhv.sem4.Battleship.model.Ship;
import at.fhv.sem4.Battleship.repository.GameRepository;
import at.fhv.sem4.Battleship.repository.GuessRepository;
import org.springframework.stereotype.Service;
import at.fhv.sem4.Battleship.repository.ShipRepository;

import java.util.List;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final ShipRepository shipRepository;
    private final GuessRepository guessRepository;

    public GameService(GameRepository gameRepository, ShipRepository shipRepository, GuessRepository guessRepository) {
        this.gameRepository = gameRepository;
        this.shipRepository = shipRepository;
        this.guessRepository = guessRepository;
    }

    public Game createGame() {
        Game game = new Game();
        game.setActive(true);
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public GameStatusDTO getGameStatus(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isEmpty()) {
            throw new IllegalArgumentException("Game not found");
        }

        GameStatusDTO gameStatus = new GameStatusDTO();
        gameStatus.setGameId(game.get().getId());

        // Überprüfen, ob das Spiel vorbei ist
        boolean gameOver = isGameOver(gameId);
        gameStatus.setActive(!gameOver);

        gameStatus.setShips(shipRepository.findAll());
        gameStatus.setGuesses(guessRepository.findAll());

        // Falls das Spiel vorbei ist, speichern wir den neuen Status
        if (gameOver) {
            game.get().setActive(false);
            gameRepository.save(game.get());
        }

        return gameStatus;
    }


    private boolean isGameOver(Long gameId) {
        List<Ship> ships = shipRepository.findAll();
        List<Guess> guesses = guessRepository.findAll();

        for (Ship ship : ships) {
            boolean allHit = true;

            for (int i = 0; i < ship.getLength(); i++) {
                int shipX = ship.getX() + (ship.getDirection().equals("HORIZONTAL") ? i : 0);
                int shipY = ship.getY() + (ship.getDirection().equals("VERTICAL") ? i : 0);

                boolean hit = guesses.stream().anyMatch(g -> g.getX() == shipX && g.getY() == shipY && g.isHit());
                if (!hit) {
                    allHit = false;
                    break;
                }
            }

            if (!allHit) {
                return false; // Mindestens ein Schiff ist noch nicht vollständig getroffen
            }
        }

        return true; // Alle Schiffe sind versenkt
    }

}
