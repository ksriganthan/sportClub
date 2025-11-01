package org.fhnw.sport.sportclub.Stadium;

import org.fhnw.sport.sportclub.Coach.Coach;
import org.fhnw.sport.sportclub.Coach.CoachNotFoundException;
import org.fhnw.sport.sportclub.Coach.CoachRepository;
import org.fhnw.sport.sportclub.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    @Autowired
    private StadiumRepository repository;

    public StadiumController(StadiumRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Stadium> getStadiums() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Stadium getStadium(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new StadiumNotFoundException(id)
        );
    }

    @PutMapping("/{id}")
    public Stadium updateStadium(@RequestBody Stadium newStadium, @PathVariable Integer id) {
        return repository.findById(id)
                .map(stadium -> {
                    stadium.setName(newStadium.getName());
                    stadium.setOrt(newStadium.getOrt());
                    return repository.save(stadium);
                }).orElseGet(() -> {
                    newStadium.setStadiumID(id);
                    return repository.save(newStadium);
                });

    }
}

