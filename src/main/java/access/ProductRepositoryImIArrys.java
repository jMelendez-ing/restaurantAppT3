package access;

import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImIArrys {

    public static List<Product> products;

    public ProductRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        products.add(new Product(1, "Carne de Res", 6000d));
        products.add(new Product(2, "Carne de Pollo", 5500d));
        products.add(new Product(3, "Carne de Lentejas", 5000d));
        /*products.add(new Product(4, "Pollo Agridulce", 5800d));
        products.add(new Product(5, "Cerdo Tropical", 6900d));
        products.add(new Product(6, "Res Teriyaki", 6200d));*/

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                products.remove(prod);
                return true;
            }
        }
        return false;
    }
}
