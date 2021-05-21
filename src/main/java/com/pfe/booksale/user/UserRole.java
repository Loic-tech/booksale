package com.pfe.booksale.user;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userRole")
public enum UserRole {
    ADMIN,USER
}
