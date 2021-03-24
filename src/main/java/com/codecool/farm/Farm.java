package com.codecool.farm;

import com.codecool.farm.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Farm {

    private final List<Animal> animals;

    public Farm(List<Animal> animalList) {
        this.animals = animalList;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void feedAnimals() {
        animals.forEach(Animal::feed);
    }

    public void butcher(Butcher butcher) {
        animals.removeIf(butcher::canButcher);
    }

    public boolean isEmpty() {
        return animals.size() == 0;
    }

    public List<String> getStatus() {
        return animals
                .stream()
                .map(a -> "There is a " + a.getSize() + " sized "
                        + a.getClass().getSimpleName().toLowerCase() + " in the farm.")
                .collect(Collectors.toList());
    }
}
