package org.fhnw.sport.sportclub.Pet;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(int message) {
        super(message + " not found");
    }
}
