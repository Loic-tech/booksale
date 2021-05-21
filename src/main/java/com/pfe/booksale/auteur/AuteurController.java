package com.pfe.booksale.auteur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auteurs")
public class AuteurController {

    @Autowired
    AuteurService auteurService;

    @PostMapping(value = "/add")
    public ResponseEntity<Auteur> addAuthor(@RequestBody Auteur auteur){
        auteurService.addAuthor(auteur);
        return new ResponseEntity<Auteur>(auteur, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Auteur>> getList(){
        List<Auteur> L =auteurService.getAuteurs();
        return new ResponseEntity<>(L,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Auteur>> getById(@PathVariable String id){
      Optional<Auteur> optionalAuteur = auteurService.getOneAuthorById(id);
      return new ResponseEntity<>(optionalAuteur,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putAuteur(@PathVariable String id, @RequestBody Auteur auteur) throws AuteurException {
        Auteur auteur1 = auteurService.updateAuteur(id,auteur);
        return new ResponseEntity<>(auteur1,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        auteurService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
