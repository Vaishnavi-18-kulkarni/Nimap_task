package Vaishnavi.nimap.example.Vaish_NimapApplication.controller;

import Vaishnavi.nimap.example.Vaish_NimapApplication.Exception.Response;
import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Category;
import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Product;
import Vaishnavi.nimap.example.Vaish_NimapApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add product here
    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // update product here
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // delete product here
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(new Response("Product deleted successfully", true), HttpStatus.OK);
    }


    // view all product here
    @GetMapping("/viewAll")
    public ResponseEntity<List<Product>> viewAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    // view single product here plz
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // get category with products
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategoryWithProducts(@PathVariable("categoryId") Long categoryId) {
        Category category = productService.getCategoryWithProducts(categoryId);
        return ResponseEntity.ok(category);
    }
}
