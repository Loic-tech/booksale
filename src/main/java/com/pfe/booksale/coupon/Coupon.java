package com.pfe.booksale.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Document(collection = "coupon")
@Setter
@Getter
@Data
public class Coupon {
    @Id
    private String id;

    private String code;
    private LocalDate expiration;
    private LocalDate instant = LocalDate.now();
    private int percent;
    private boolean isActive;

    public Coupon(String code,int percent) {
        this.code = code;
        this.instant = LocalDate.now();
        this.percent = percent;
        this.isActive = true;
    }


}
