package com.pfe.booksale.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

    @Autowired
    CouponRepository couponRepository;

    @GetMapping(value = "/reduce")
    public ResponseEntity<?> getCoupon(@RequestParam String code){
        Optional<Coupon> optionalCoupon = couponRepository.findByCode(code);

        if(optionalCoupon.isEmpty())
            return new ResponseEntity<>("404 ! NOT FOUND", HttpStatus.NOT_FOUND);

        Coupon coupon = optionalCoupon.get();

        if(coupon.getExpiration().equals(LocalDate.now()))
        {
            coupon.setActive(false);
            return new ResponseEntity<>(coupon,HttpStatus.NOT_ACCEPTABLE);
        }


        return new ResponseEntity<>(optionalCoupon,HttpStatus.OK);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon){
        couponRepository.save(coupon);
        return new ResponseEntity<>(coupon,HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getCoupons(){
        List<Coupon> couponList = couponRepository.findAll();
        return new ResponseEntity<>(couponList,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOneCoupons(@PathVariable String id){
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        return new ResponseEntity<>(optionalCoupon,HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putCoupon(@PathVariable String id,@RequestBody CouponM couponm){
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);

        if(optionalCoupon.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Coupon coupon = optionalCoupon.get();

        coupon.setCode(couponm.getCode());
        coupon.setPercent(couponm.getPercent());
        coupon.setExpiration(couponm.getExpiration());

        couponRepository.save(coupon);

        return new ResponseEntity<>(coupon,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCoupon(@PathVariable String id){
        couponRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
