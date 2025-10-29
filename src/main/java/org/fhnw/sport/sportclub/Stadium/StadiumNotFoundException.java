package org.fhnw.sport.sportclub.Stadium;

public class StadiumNotFoundException extends RuntimeException {
    public StadiumNotFoundException(Integer id) {
        super("Stadium not found: " + id);
    }
}
