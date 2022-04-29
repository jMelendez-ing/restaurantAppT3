package BurgerApp;

import access.IProductRepository;
import access.ProductRepositoryImplArrays;
import domain.Product;
import domain.Size;
import services.DishBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BurgerDishBuilder extends DishBuilder {

    IProductRepository myRepository;
    BurgerDish myBurgerDish;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Product> allProducts;
    List<Product>  bases;
    List<Product>  options;


    private Product read(List<Product> myProducts, String foodPart) {
        String input = "";
        try {
            int i =1;
            System.out.println("Seleccione una "+foodPart);
            for (Product each: myProducts){
                System.out.println(""+i+". "+ each.getName() + ":"+each.getPrice());
                i++;
            }
            System.out.println("Ingrese el código de la "+ foodPart);
            input = br.readLine();
        } catch (IOException e) {
        }
        return myProducts.get(Integer.parseInt(input)-1);
    }

    private String read(String message) {
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
        } catch (IOException e) {
        }
        return input;
    }

    @Override
    public DishBuilder init() {
        myRepository = new ProductRepositoryImplArrays();
        myDish = new BurgerDish(0.0);
        myBurgerDish = (BurgerDish) myDish;
        //Obtenemos todos los productos
        allProducts = myRepository.findAll();
        // Obtenemos las bases y las opciones
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for(Product each: allProducts){
            if(each.getId()<4)
                bases.add(each);
            else
                options.add(each);
        }
        return this ;
    }

    @Override
    public DishBuilder setCore() {
        myBurgerDish.setBase(read(bases, "Base"));
        return this;
    }

    @Override
    public boolean addPart() {
        myBurgerDish.addOption(read(options, "Opcion"));
        return ("S".equals(read("Presione S para más opciones")));

    }

    @Override
    public DishBuilder setSize() {
        String tamano = read("Presione la letra correspondiente para el tamaño Personal(P), Doble (D), Familiar (F)");
        if(tamano.equals("F")) myBurgerDish.setSize(Size.FAMILY);
        if(tamano.equals("D")) myBurgerDish.setSize(Size.DOUBLE);
        if(tamano.equals("P")) myBurgerDish.setSize(Size.PERSONAL);
        return this;
    }
}
