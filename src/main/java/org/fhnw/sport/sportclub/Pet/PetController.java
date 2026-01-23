package org.fhnw.sport.sportclub.Pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetRepository petRepository;

    // Hole alle Pets
    @GetMapping("/pets")
    public List<Pet> all() {
        return petRepository.findAll();
    }
    // Hole ein Pet per Id
    @GetMapping("/pets{id}")
    public Pet one(@PathVariable int id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }
    // Erstelle ein neues Pet
    @PostMapping("/pets")
    public Pet newPet(@RequestBody Pet newPet) {
        return petRepository.save(newPet);
    }
    // Ersetze ein Pet per Id oder erstelle es, wenn es nicht existiert
    @PutMapping("/pets/{id}")
    public Pet replacePet(@RequestBody Pet newPet, @PathVariable int id) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setName(newPet.getName());
                    pet.setAge(newPet.getAge());
                    return petRepository.save(pet);
                })
                .orElseGet(() -> {
                    newPet.setId(id);
                    return petRepository.save(newPet);
                });
    }

    @DeleteMapping("/pets/{id}")
    void deletePet(@PathVariable int id) {
        petRepository.deleteById(id);
    }
}
