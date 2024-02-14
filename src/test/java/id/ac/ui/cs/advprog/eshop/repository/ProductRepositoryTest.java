package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setup() {

    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
        assertEquals(product.getProductName(), savedProduct.getProductName());
    }

    @Test
    void createProductWithSameName() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("eb558e9f-1c39-460e-8860-71af6afw65453ww");
        product2.setProductName("Sampo Cap Bambang");
        product2.setProductQuantity(100);
        productRepository.create(product2);
        assertEquals(200, productRepository.findProductByName("Sampo Cap Bambang").getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteLast() { //Delete elemen terakhir
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        assertEquals(2, productRepository.getProductData().size());
        Iterator<Product> productIterator = productRepository.findAll();
        productIterator.next();
        assertTrue(productIterator.hasNext());
        productRepository.deleteProductByName(product2.getProductName());
        assertEquals(1, productRepository.getProductData().size());
        assertFalse(productIterator.hasNext());
    }
    @Test
    void deleteFirst() { //Delete elemen pertama
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("a0f9de46-90b1-437d-a0bf-a093edde8087");
        product3.setProductName("Sampo Cap Jarwo");
        product3.setProductQuantity(500);
        productRepository.create(product3);

        assertEquals(3, productRepository.getProductData().size());
        productRepository.deleteProductByName(product1.getProductName());
        assertEquals(2, productRepository.getProductData().size());
        assertEquals("Sampo Cap Jarwo", productRepository.getProductData().getFirst().getProductName());
    }

    @Test
    void deleteMiddle() { //Delete elemen tengah
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("a0f9de46-90b1-437d-a0bf-a093edde8087");
        product3.setProductName("Sampo Cap Jarwo");
        product3.setProductQuantity(500);
        productRepository.create(product3);

        assertEquals(3, productRepository.getProductData().size());
        assertEquals("Sampo Cap Bambang", productRepository.getProductData().getFirst().getProductName());
        assertEquals("Sampo Cap Jarwo", productRepository.getProductData().get(1).getProductName());
        assertEquals("Sampo Cap Usep", productRepository.getProductData().getLast().getProductName());
        productRepository.deleteProductByName(product3.getProductName());
        assertEquals(2, productRepository.getProductData().size());
        assertEquals("Sampo Cap Bambang", productRepository.getProductData().getFirst().getProductName());
        assertEquals("Sampo Cap Usep", productRepository.getProductData().getLast().getProductName());
    }

    @Test
    void testEdit() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product3 = new Product();
        product3.setProductId("a0f9de46-90b1-437d-a0bf-a093edde8087");
        product3.setProductName("Sampo Cap Jarwo");
        product3.setProductQuantity(500);

        productRepository.editProduct("Sampo Cap Bambang", product3);
        assertEquals("Sampo Cap Jarwo", productRepository.getProductData().getFirst().getProductName());
        assertEquals("a0f9de46-90b1-437d-a0bf-a093edde8087", productRepository.getProductData().getFirst().getProductId());
        assertEquals(500, productRepository.getProductData().getFirst().getProductQuantity());
    }
}
