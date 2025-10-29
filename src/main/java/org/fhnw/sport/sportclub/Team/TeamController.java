package org.fhnw.sport.sportclub.Team;

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
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Team> getTeams() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new TeamNotFoundException(id)
        );
    }
}

