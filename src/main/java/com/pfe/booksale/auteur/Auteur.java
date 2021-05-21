package com.pfe.booksale.auteur;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auteur")
@Data
public class Auteur {

    @Id
    private String id;
    private String name;
    private String image;

    public Auteur(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
