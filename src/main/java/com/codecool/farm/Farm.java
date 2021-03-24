package com.codecool.farm;

import com.codecool.farm.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Farm {

    private final List<Animal> animals;

    Farm(List<Animal> animalList) {
        this.animals = animalList;
    }

    List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    void feedAnimals() {
        animals.forEach(Animal::feed);
    }

    void butcher(Butcher butcher) {
        animals.removeIf(butcher::canButcher);
    }

    boolean isEmpty() {
        return animals.size() == 0;
    }

    List<String> getStatus() {
        return animals
                .stream()
                .map(a -> "There is a " + a.getSize() + " sized "
                        + a.getClass().getSimpleName().toLowerCase() + " in the farm.")
                .collect(Collectors.toList());
    }
}
