package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        Product sameProductName = findProductByName(product.getProductName());
        if (sameProductName != null) {
            sameProductName.setProductQuantity(sameProductName.getProductQuantity() + product.getProductQuantity());
            return sameProductName;
        } else {
            productData.add(product);
            productData.sort((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));
            return product;
        }
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
  
    public Product deleteProductByName(String name) {
        Product yangMauDihapus = findProductByName(name);
        productData.remove(yangMauDihapus);
        productData.sort((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));
        return yangMauDihapus;

    public Product editProduct(String name, Product newProduct) {
        Product product = findProductByName(name);
        product.setProductName(newProduct.getProductName());
        product.setProductQuantity(newProduct.getProductQuantity());
        return product;
    }
}
