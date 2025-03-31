package Vaishnavi.nimap.example.Vaish_NimapApplication.service;

import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Category;
import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Product;
import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Category getCategoryWithProducts(Long categoryId);
}