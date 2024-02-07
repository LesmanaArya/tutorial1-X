package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
    public Product findProductByName(String name) {
        for (Product product : productData) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    public Product editProduct(String name, Product newProduct) {
        Product product = findProductByName(name);
        product.setProductName(newProduct.getProductName());
        product.setProductQuantity(newProduct.getProductQuantity());
        return product;
    }
}
