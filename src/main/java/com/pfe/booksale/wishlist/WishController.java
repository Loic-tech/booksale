package com.pfe.booksale.wishlist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wish")
public class WishController {

    @Autowired
    WishRepository wishRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addWish(@RequestBody WishList wishList){
        wishRepository.save(wishList);

        return new ResponseEntity<>(wishList, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all/{idu}")
    public ResponseEntity<?> getWish(@PathVariable String idu){
     List<WishList> optionalWishList = wishRepository.findByIdu(idu);

     if(optionalWishList.isEmpty())
         return new ResponseEntity<>("EMPTY LIST",HttpStatus.OK);

     return new ResponseEntity<>(optionalWishList,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteWish(@PathVariable String id){
        wishRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
