package com.pfe.booksale.auteur;

import com.pfe.booksale.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class AuteurService {

    private List<Auteur> auteurList = new ArrayList<>();

    @Autowired
    AuteurRepository auteurRepository;

    public void addAuthor(Auteur auteur){
        auteurRepository.save(auteur);
        auteurList.add(auteur);
    }

    public List<Auteur> getAuteurs(){
        return auteurRepository.findAll();
    }

    public Optional<Auteur> getOneAuthorById(String id){
        return auteurRepository.findById(id);
    }

    public Optional<Auteur> getOneAuthorByName(String name){
        return auteurRepository.findByname(name);
    }

    public Auteur updateAuteur(String id, Auteur auteur) throws AuteurException{
        Optional<Auteur> auteurOptional = auteurRepository.findById(id);

        if(auteurOptional.isEmpty()){
            throw new AuteurException("RAS");
        }

        Auteur auteur1 = auteurOptional.get();

        auteur1.setName(auteur.getName());
        auteur1.setImage(auteur.getImage());



        for(int i = 0 ; i < auteurList.size() ; i++) {
            if (auteur.equals(auteurList.get(i))) {
                auteurList.remove(auteur);
                auteurList.add(auteur1);
            }
        }

        auteurRepository.save(auteur1);

        return auteur1;
    }

    public void deleteById(String id){
        auteurRepository.deleteById(id);
    }




}
