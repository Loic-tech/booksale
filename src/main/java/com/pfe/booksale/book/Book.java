package com.pfe.booksale.book;

import com.pfe.booksale.auteur.Auteur;
import com.pfe.booksale.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document(collection = "book")
public class Book {

    @Id
    private String id;
    private String title;
    private float price;
    private String description;
    private String image;
    private int purchased;
    private LocalDate creation;
    private Category category;
    private Auteur author;


    public Book(String id, String title, float price, String description, String image, int purchased, Category category, Auteur author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.purchased = purchased;
        this.creation = LocalDate.now();
        this.category = category;
        this.author = author;
    }
}
