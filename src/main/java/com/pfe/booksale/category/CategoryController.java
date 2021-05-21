package com.pfe.booksale.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> getList(){
                List<Category> L = categoryService.getCategories();
                return new ResponseEntity<>(L,HttpStatus.OK);
    }

    @GetMapping(value = "/bb")
    public ResponseEntity<List<Category>> getALLName(){
        List<Category> list = categoryService.getAllListByName();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> getById(@PathVariable String id){
        Optional<Category> optionalCategory =categoryService.getOneCategoryById(id);
        return new ResponseEntity<>(optionalCategory,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable String id,@RequestBody Category category) throws CategoryException {
        Category category1 = categoryService.updateCategory(id,category);
        return new ResponseEntity<>(category1,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable String id){
        categoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }




}
