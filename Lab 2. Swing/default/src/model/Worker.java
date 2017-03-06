package model;

import model.animal.Animal;
import model.animal.Elephant;
import model.animal.Ostrich;
import org.w3c.dom.ranges.RangeException;

import java.util.List;

/**
 * Created by Alex on 21.02.2017.
 */
public class Worker {
    private List<Animal> animals;

    /**
     * Default constructor
     * @param animals Array of animals, with which he is working
     */
    public Worker(final List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Feed Animal
     *
     * @param index Number of animal
     * @param food  Food to animal
     * @return Info to show
     * @throws RangeException Bad index
     */
    public String feedAnimal(final int index, final String food) throws RangeException {
        if (index < 0 || index >= animals.size()) {
            throw new RangeException((short) 1, "Bad index");
        }

        Animal currentAnimal = animals.get(index);

        return (currentAnimal.getName() + " сказал: " + currentAnimal.Eat(food));
    }

    /**
     * Clear the animal's cage
     * @param index number of animal
     * @return Message info to show
     * @throws RangeException Bad index
     */
    public String ClearAnimalCage(final int index) throws RangeException {
        if (index < 0 || index >= animals.size()) {
            throw new RangeException((short) 1, "Bad index");
        }

        Animal currentAnimal = animals.get(index);

        String message = "Клетка у животного " + currentAnimal.getName();

        if (!currentAnimal.ClearCage()) {
            message += " не почищена. Она и так чистая.";
        } else {
            message += " почищена.";
        }

        return message;
    }
}
