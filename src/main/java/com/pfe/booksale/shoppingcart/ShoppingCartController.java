package com.pfe.booksale.shoppingcart;


import com.pfe.booksale.book.Book;
import com.pfe.booksale.book.BookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping(value = "shop")
public class ShoppingCartController {

    @Autowired
    shoppingCartRepository shoppingCartRepository;





    @PostMapping(value = "/adding")
    public ResponseEntity<?> saveBook( @RequestBody ShoppingCart shoppingCart){
        shoppingCart.setBook(shoppingCart.getBook());
        shoppingCart.setIde(shoppingCart.getIde());
        shoppingCart.setQuantity(shoppingCart.getQuantity());
        shoppingCartRepository.save(shoppingCart);

        return new ResponseEntity<>(shoppingCart, HttpStatus.CREATED);

    }



    @GetMapping(value = "/cart/{id}")
    public ResponseEntity<?> AllCart(@PathVariable String id){
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findShoppingCartByIde(id);

        return new ResponseEntity<>(shoppingCartList,HttpStatus.OK);
    }

    @DeleteMapping(value = "/cart/{id}")
    public ResponseEntity<?> Delete(@PathVariable String id){
        shoppingCartRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value ="/modify/{id}" )
    public ResponseEntity<?> Update(@PathVariable String id, @RequestParam String idb, @RequestParam int quantity) throws ShoppingCartException {

            List<ShoppingCart> shoppingCartList = shoppingCartRepository.findByIde(id);
            if(shoppingCartList.isEmpty())
                throw new ShoppingCartException("404");
            else {
                for (ShoppingCart shoppingCart : shoppingCartList) {
                    if (idb.equals(shoppingCart.getBook().getId())) {
                        shoppingCart.setQuantity(shoppingCart.getQuantity() + quantity);
                        shoppingCartRepository.save(shoppingCart);

                        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
                    }
                }
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @GetMapping(value ="/modifyq/{id}" )
    public ResponseEntity<?> UpdateQuantity(@PathVariable String id, @RequestParam String idb, @RequestParam int quantity) throws ShoppingCartException {

        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findByIde(id);
        if(shoppingCartList.isEmpty())
            throw new ShoppingCartException("404");
        else {
            for (ShoppingCart shoppingCart : shoppingCartList) {
                if (idb.equals(shoppingCart.getBook().getId())) {
                    shoppingCart.setQuantity(quantity);
                    shoppingCartRepository.save(shoppingCart);

                    return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
                }
            }
        }


        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
