package com.pfe.booksale.checkout;


import com.pfe.booksale.shoppingcart.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

import java.util.List;

@Document(collection = "checkout")
@Getter
@Setter
public class Checkout {

    @Id
    private String id;

    private List<ShoppingCart> shoppingCart;
    private float total;
    private String email;
    private LocalDateTime localDate;
    private String notes;
    private boolean status;
    private int delivery;

    public Checkout(List<ShoppingCart> shoppingCart, float total,String notes) {
        this.shoppingCart = shoppingCart;
        this.total = total;
        this.localDate = LocalDateTime.now();
        this.notes = notes;
        this.status = false;
    }
}
