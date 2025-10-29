package org.fhnw.sport.sportclub.Coach;

public class CoachNotFoundException extends RuntimeException {
    public CoachNotFoundException(Integer id) {
        super("Coach not found: " + id);
    }
}
