package model.animal;

import model.Body;

/**
 * Created by Alex on 21.02.2017.
 */
public class Animal {
    private Body body;
    private String name;
    private boolean isCageClear;

    public Animal(final double length, final double width, final double height, final double mass, final String name) {
        body = new Body(length, width, height, mass);
        this.name = name;
    }

    /**
     * Eat the food
     *
     * @param food Food to animal
     * @return what animal is said
     */
    public String Eat(final String food) {
        isCageClear = false;
        return ("Спасибо. " + food + " был очень вкусным!");
    }

    /**
     * Clear animal's cage
     * @return Was cage clear
     */
    public boolean ClearCage() {
        boolean res = !isCageClear;
        isCageClear = true;

        return res;
    }

    public String getName() {
        return name;
    }

    public Body getBody() {
        return body;
    }

    public boolean isCageClear() {
        return isCageClear;
    }
}
