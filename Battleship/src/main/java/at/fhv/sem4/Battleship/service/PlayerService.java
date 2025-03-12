package at.fhv.sem4.Battleship.service;

import at.fhv.sem4.Battleship.model.Player;
import at.fhv.sem4.Battleship.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

}
