package org.fhnw.sport.sportclub.Team;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(Integer id) {
        super("Team not found: " + id);
    }
}
