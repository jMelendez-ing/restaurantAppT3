package services;

import BurgerApp.BurgerDishBuilder;
import domain.Dish;

public class DishDirector {

    private final BurgerDishBuilder builder;

    public DishDirector(BurgerDishBuilder builder) {
        this.builder = builder;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create() {
        boolean moreParts = true;
        builder.init();
        builder.setCore();
        while (moreParts{
            moreParts = builder.addPart();
        }
        builder.setSize();
    }

}
