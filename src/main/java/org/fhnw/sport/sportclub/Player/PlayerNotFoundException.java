package org.fhnw.sport.sportclub.Player;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Integer id) {
        super("Player not found: " + id);
    }
}
