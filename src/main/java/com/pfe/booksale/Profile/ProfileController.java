package com.pfe.booksale.Profile;

import com.pfe.booksale.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile){
            profileRepository.save(profile);
            return  new ResponseEntity<>(profile,HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<?> getProfile(@RequestParam String id){
        Optional<Profile> profile = profileRepository.findByIduser(id);

        if(profile.isEmpty())
            return new ResponseEntity<String>("404 NOT FOUND",HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllProf(){

        List<Profile> list = profileRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping(value = "/modify/{id}")
    public ResponseEntity<?> putProfile(@PathVariable String id, @RequestBody Profile profile){
        Optional<Profile> optionalProfile = profileRepository.findByIduser(id);

        if(optionalProfile.isEmpty())
            return new ResponseEntity<String>("404 ! NOT FOUND",HttpStatus.NOT_FOUND);

        Profile profile1 = optionalProfile.get();

        profile1.setIduser(profile.getIduser());
        profile1.setFirstname(profile.getFirstname());
        profile1.setLastname(profile.getLastname());
        profile1.setCountry(profile.getCountry());
        profile1.setAddress(profile.getAddress());
        profile1.setCity(profile.getCity());
        profile1.setZipcode(profile.getZipcode());
        profile1.setPhone(profile.getPhone());

        profileRepository.save(profile1);

        return new ResponseEntity<>(profile1,HttpStatus.OK);
    }

}
