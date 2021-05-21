package com.pfe.booksale.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    public static List<Book> bookList = new ArrayList<>();



    @PostMapping(value = "/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
         bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = bookRepository.findAll();
        bookList = bookRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping(value = ("/{id}"))
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable String id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return new ResponseEntity<>(optionalBook,HttpStatus.OK);
    }

    @PutMapping(value = "/modify/{id}")
    public ResponseEntity<?> putPurchase(@PathVariable String id){
        Optional<Book> optionalBook = bookRepository.findById(id);


        if(optionalBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        int total = 1;

            Book book = optionalBook.get();
            book.setPurchased(book.getPurchased() + total);

            bookRepository.save(book);

            return new ResponseEntity<>(book,HttpStatus.OK);

    }

    /*@PutMapping(value = "/quantity/{id}")
    public ResponseEntity<?> putQuantity(@PathVariable String id){
        Optional<Book> optionalBook = bookRepository.findById(id);


        if(optionalBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        int total = 1;

        Book book = optionalBook.get();
        book.setPurchased(book.getPurchased() + total);

        bookRepository.save(book);

        return new ResponseEntity<>(book,HttpStatus.OK);
    }*/

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putBook(@PathVariable String id, @RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Book book1 = optionalBook.get();

        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setCreation(book.getCreation());
        book1.setDescription(book.getDescription());
        book1.setImage(book.getImage());
        book1.setPrice(book.getPrice());
        book1.setPurchased(book.getPurchased());
        book1.setTitle(book.getTitle());

        bookRepository.save(book1);

        return new ResponseEntity<>(book1,HttpStatus.OK);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<List<Book>> getByCat(@PathVariable String id){
        List<Book> L = bookRepository.findByCategoryId(id);
        return new ResponseEntity<>(L,HttpStatus.OK);
    }

    @GetMapping(value = "/auteurs/{id}")
    public ResponseEntity<List<Book>> getByAuth(@PathVariable String id){
        List<Book> L = bookRepository.findByAuthorId(id);
        return new ResponseEntity<>(L,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) throws BookException{
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
