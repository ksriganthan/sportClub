package org.fhnw.sport.sportclub.Skill;

public class SkillNotFoundException extends RuntimeException {
    public SkillNotFoundException(Integer id) {
        super("Skill not found: " + id);
    }
}
