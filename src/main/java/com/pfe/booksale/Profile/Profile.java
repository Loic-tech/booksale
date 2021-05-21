package com.pfe.booksale.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profile")
@Getter
@Setter
@AllArgsConstructor
@Data
public class Profile {
    @Id
    private String id;

    private String iduser;
    private String firstname;
    private String lastname;
    private String country;
    private String address;
    private String city;
    private String zipcode;
    private String phone;

}
