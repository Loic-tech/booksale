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
    private String isbn;
    private float price;
    private String description;
    private String image;
    private int purchased;
    private int quantity;
    private LocalDate creation;
    private Category category;
    private Auteur author;
    private LocalDate date;


    public Book(String id, String title, float price, String description, String image, int quantity,int purchased, Category category, Auteur author,LocalDate date) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.purchased = purchased;
        this.creation = LocalDate.now();
        this.category = category;
        this.author = author;
        this.date = date;
    }
}
