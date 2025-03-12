package at.fhv.sem4.Battleship.service;

import at.fhv.sem4.Battleship.model.Game;
import at.fhv.sem4.Battleship.model.Player;
import at.fhv.sem4.Battleship.model.Ship;
import at.fhv.sem4.Battleship.repository.GameRepository;
import at.fhv.sem4.Battleship.repository.PlayerRepository;
import at.fhv.sem4.Battleship.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public ShipService(ShipRepository shipRepository, GameRepository gameRepository, PlayerRepository playerRepository) {
        this.shipRepository = shipRepository;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public Ship placeShip(Long gameId, Long playerId, int x, int y, int length, String direction) {
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

        System.out.println("✅ Both Game and Player found, placing ship...");
        Ship ship = new Ship();
        ship.setGame(game.get());
        ship.setPlayer(player.get());
        ship.setX(x);
        ship.setY(y);
        ship.setLength(length);
        ship.setDirection(direction);

        return shipRepository.save(ship);
    }

}
