package com.pfe.booksale.shoppingcart;

import com.pfe.booksale.book.Book;
import com.pfe.booksale.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Document(collection = "shoppingCart")
@Getter
@Setter
@Data
@AllArgsConstructor
public class ShoppingCart {

    @Id
    private String id;

    private String ide;
    private Book book;
    private Integer quantity;


}
