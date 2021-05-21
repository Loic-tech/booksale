package com.pfe.booksale.coupon;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
@AllArgsConstructor
public class CouponM {
    private String code;
    private int percent;
    private LocalDate expiration;
}
