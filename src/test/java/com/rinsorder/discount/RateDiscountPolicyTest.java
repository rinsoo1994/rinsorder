package com.rinsorder.discount;

import com.rinsorder.member.Grade;
import com.rinsorder.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP Rate 할인은 10% 할인이 되어야한다.")
    void discount (){
        // given
        Member member = new Member(1L, Grade.VIP, "surinzzang");
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 300000);
        // then
        Assertions.assertThat(discountPrice).isEqualTo(30000);
    }


    @Test
    @DisplayName("Basic은 할인 적용 안된다. ")
    void discount_f (){
        // given
        Member member = new Member(1L, Grade.Basic, "surinzzang");
        // when
        int discountPrice = rateDiscountPolicy.discount(member, 300000);
        // then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }
}
