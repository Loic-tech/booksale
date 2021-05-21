package com.pfe.booksale.wishlist;

import com.pfe.booksale.book.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WishList")
@Setter
@Getter
@Data
public class WishList {
    @Id
    public String id;

    public String idu;
    public Book book;

    public WishList(String idu, Book book) {
        this.idu = idu;
        this.book = book;
    }
}
