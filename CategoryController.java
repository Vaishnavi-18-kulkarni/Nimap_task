package Vaishnavi.nimap.example.Vaish_NimapApplication.controller;


import Vaishnavi.nimap.example.Vaish_NimapApplication.Exception.Response;
import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Category;
import Vaishnavi.nimap.example.Vaish_NimapApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    // Add Category here
    @PostMapping("/save")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category category1=this.categoryService.addCategory(category);

        return new ResponseEntity<Category>(HttpStatus.CREATED);
    }

    // update Category here
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,@RequestBody Category category)
    {
        Category category1=this.categoryService.updateCategory(id,category);

        return new ResponseEntity<Category>(HttpStatus.CREATED);
    }

    // delete Category here
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCategory(@PathVariable("id") Long id)
    {
        this.categoryService.deleteCategory(id);

        return new ResponseEntity<>(new Response("deleted successFully",false),HttpStatus.OK);
    }

    // get all category here
    @GetMapping("/viewAll")
    public ResponseEntity<List<Category>> viewAllCategories()
    {
        List<Category> categoryList=this.categoryService.getAllCategories();

        return ResponseEntity.ok(categoryList);
    }

    // get category by id
    @GetMapping("getById/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long id)
    {
        Category category=this.categoryService.getCategoryById(id);

        return ResponseEntity.ok(category);
    }
}
