package com.rinsorder.discount;

import com.rinsorder.member.Grade;
import com.rinsorder.member.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
