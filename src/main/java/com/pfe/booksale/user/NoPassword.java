package com.pfe.booksale.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Data
public class NoPassword {
    private String username;
    private String email;
    private Set<String> role;

    public NoPassword(String username, String email, Set<String> role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
