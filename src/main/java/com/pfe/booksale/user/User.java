package com.pfe.booksale.user;


import com.pfe.booksale.shoppingcart.ShoppingCart;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;


@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private Set<Role> roleSet = new HashSet<>();
    private ShoppingCart shoppingCart;

    public User(String username, String email, String password, ShoppingCart shoppingCart) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.shoppingCart = shoppingCart;
    }



    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
