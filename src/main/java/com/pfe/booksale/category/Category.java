package com.pfe.booksale.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorie")
@AllArgsConstructor
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private int min;

}
