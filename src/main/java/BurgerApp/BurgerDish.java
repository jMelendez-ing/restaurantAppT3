package BurgerApp;

import domain.Dish;
import domain.Product;
import domain.Size;

import java.util.List;
import java.util.Vector;

public class BurgerDish extends Dish {

    private final List<Product> myOptions;
    private Product base;
    private Size size;

    BurgerDish(double p) {
        this.price = p;
        myOptions = new Vector<>();
    }

    void addOption(Product option) {
        getMyOptions().add(option);
    }

    public List<Product> getMyOptions() {
        return myOptions;
    }

    public Product getBase() {
        return base;
    }

    void setBase(Product base) {
        this.base = base;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        price = base.getPrice();
        for (Product product : myOptions) {
            price = price + product.getPrice();
        }
        if (size.equals(Size.DOUBLE.getDoubleDataData())) price *= Size.DOUBLE.getDoubleDataData();
        if (size.equals(Size.FAMILY.getDoubleDataData())) price *= Size.FAMILY.getDoubleDataData();
        return price;

    }
}

