package com.pfe.booksale.checkout;

import com.pfe.booksale.book.Book;
import com.pfe.booksale.book.BookController;
import com.pfe.booksale.shoppingcart.ShoppingCart;
import com.pfe.booksale.shoppingcart.shoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/checkout")
public class CheckoutController {

    @Autowired
    CheckoutRepository checkoutRepository;

    @Autowired
    SendEmailConfirmationCheckout sendEmailConfirmationCheckout;

    @Autowired
    shoppingCartRepository shoppingCartRepository;

    @Autowired
    BookController bookController;


    @PostMapping(value = "/add")
    public ResponseEntity<?> addCheck(@RequestBody Checkout checkout){
        sendEmailConfirmationCheckout.SendEmail(checkout.getEmail(),"Order received Successfully !","CONFIRMATION ORDER");
        for(ShoppingCart shoppingCart : checkout.getShoppingCart()){
            shoppingCartRepository.delete(shoppingCart);
        }

      for(int i = 0 ; i < checkout.getShoppingCart().size() ; i++){
          bookController.putPurchase(
                  checkout.getShoppingCart().get(i)
                  .getBook()
                  .getId()
          );
      }


       checkoutRepository.save(checkout);
        return new ResponseEntity<>(checkout, HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<?> getOrder(@RequestParam String email){
        List<Checkout> checkout = checkoutRepository.findByEmail(email);
        return new ResponseEntity<>(checkout,HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id){
        Optional<Checkout> optionalCheckout = checkoutRepository.findById(id);
        return new ResponseEntity<>(optionalCheckout,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id){
        checkoutRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/modify/{id}")
    public ResponseEntity<?> putOrder(@PathVariable String id, @RequestBody Checkout status){
        Optional<Checkout> optionalCheckout = checkoutRepository.findById(id);

        if(optionalCheckout.isEmpty())
            return new ResponseEntity<>("404 ! NOT FOUND",HttpStatus.NOT_FOUND);

        Checkout checkout = optionalCheckout.get();
        checkout.setStatus(status.isStatus());

        checkoutRepository.save(checkout);

        return new ResponseEntity<>(checkout,HttpStatus.OK);
    }


    @GetMapping(value = "/all")
    public ResponseEntity<?> allCheck(){
        List<Checkout> checkoutList = checkoutRepository.findAll();
        return new ResponseEntity<>(checkoutList,HttpStatus.OK);
    }
}
