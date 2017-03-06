package model;

import model.animal.Animal;
import model.animal.Elephant;
import model.animal.Ostrich;

import java.util.*;

/**
 * Created by Alex on 21.02.2017.
 */
public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private Worker defaultWorker;

    public Zoo() {
        //animals = new Animal[2];

        animals.add(0, new Ostrich("Петя"));
        animals.add(1, new Elephant("Вася"));

        defaultWorker = new Worker(animals);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Worker getWorker() {
        return defaultWorker;
    }
}
