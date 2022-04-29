package services;

import BurgerApp.BurgerDishBuilder;
import domain.Dish;

public class DishDirector {

    private final DishBuilder builder;

    public DishDirector(DishBuilder builder) {
        this.builder = builder;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create() {
        boolean moreParts = true;
        builder.init();
        builder.setCore();
        while (moreParts){
            moreParts = builder.addPart();
        }
        builder.setSize();
    }

}
