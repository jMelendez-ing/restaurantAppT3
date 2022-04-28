package BurgerApp;

import domain.Dish;
import services.DishDirector;

public class Restaurant {

    public static void main(String[] args) {

        DishDirector director = new DishDirector(new BurgerDishBuilder());
        director.create();
        Dish myDish = director.getDish();
        System.out.println("The dish is :" + myDish.getPrice() + " COP");
    }
}
