package org.fhnw.sport.sportclub.Skill;

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
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillRepository repository;

    public SkillController(SkillRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Skill> getSkills() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new SkillNotFoundException(id)
        );
    }
}

