package com.rinsorder.order;

import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.Grade;
import com.rinsorder.member.Member;
import com.rinsorder.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, Grade.VIP, "rinsoo"));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "ITEM1", 10000);
        System.out.println(order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
