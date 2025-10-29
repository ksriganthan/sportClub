package org.fhnw.sport.sportclub.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachRepository repository;

    public CoachController(CoachRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Coach> getCoaches() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Coach getCoach(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new CoachNotFoundException(id)
        );
    }
}
