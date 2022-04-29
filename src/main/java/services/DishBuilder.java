package services;

import domain.Dish;

public abstract class DishBuilder {

    protected Dish myDish;

    Dish getDish() {
        return myDish;
    }

    public DishBuilder init() {
        return this;
    }

    public DishBuilder setCore() {
        return this;
    }

    public boolean addPart() {
        return false;
    }

    public DishBuilder setSize() {
        return this;
    }
}
