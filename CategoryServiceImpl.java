package Vaishnavi.nimap.example.Vaish_NimapApplication.service;

import Vaishnavi.nimap.example.Vaish_NimapApplication.Exception.NotFoundException;
import Vaishnavi.nimap.example.Vaish_NimapApplication.model.Category;
import Vaishnavi.nimap.example.Vaish_NimapApplication.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    // Add Category here
    @Override
    public Category addCategory(Category category) {

        return this.categoryRepository.save(category);
    }

    // update Category here
    @Override
    public Category updateCategory(Long id, Category category) {
        Category category1=this.categoryRepository.findById(id).orElseThrow(()->new NotFoundException("id not found with given id"));

        category1.setName(category.getName());
        category1.setEmail(category.getEmail());
        category1.setContact(category.getContact());

        return categoryRepository.save(category1);
    }

    // delete Category here
    @Override
    public void deleteCategory(Long id) {

        Category category=this.categoryRepository.findById(id).orElseThrow(()->new NotFoundException("id not found with given id"));

        this.categoryRepository.delete(category);

    }

    // get all category here
    @Override
    public List<Category> getAllCategories() {

        return this.categoryRepository.findAll();
    }

    // get category by id
    @Override
    public Category getCategoryById(Long id) {

        Category category1=this.categoryRepository.findById(id).orElseThrow(()->new NotFoundException("id not found with given id"));

        return category1;
    }
}
