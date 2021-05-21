package com.pfe.booksale.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class CategoryService {

    public List<Category> categoryList = new ArrayList<Category>();

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
        categoryList.add(category);

    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getOneCategoryById(String id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> getOneCategoryByName(String name){
        return categoryRepository.findByname(name);
    }

    public List<Category> getAllListByName(){
        return categoryRepository.findAllByname();
    }

    public Category updateCategory(String id,Category category) throws CategoryException{
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isEmpty()){
            throw new CategoryException("Category NOT FOUND !");
        }

        Category category1 = optionalCategory.get();

        category1.setName(category.getName());

        categoryRepository.save(category1);

        for(int i = 0 ; i < categoryList.size() ; i++){
            if(category.equals(categoryList.get(i))){
                categoryList.remove(category);
                categoryList.add(category1);
            }
        }
        return category1;
    }

    public void deleteById(String id){
        categoryRepository.deleteById(id);

    }

    public void deleteByName(Category category){
        categoryRepository.deleteByname(category.getName());
        categoryList.remove(category);

    }
}
