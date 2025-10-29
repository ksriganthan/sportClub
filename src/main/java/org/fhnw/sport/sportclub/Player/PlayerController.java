package org.fhnw.sport.sportclub.Player;

import org.fhnw.sport.sportclub.Coach.Coach;
import org.fhnw.sport.sportclub.Coach.CoachNotFoundException;
import org.fhnw.sport.sportclub.Coach.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Player> getPlayers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new PlayerNotFoundException(id)
        );
    }
}

