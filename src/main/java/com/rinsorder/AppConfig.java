package com.rinsorder;

import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.MemberService;
import com.rinsorder.member.MemberServiceImpl;
import com.rinsorder.member.MemoryMemberRepository;
import com.rinsorder.order.OrderService;
import com.rinsorder.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy()
        );
    }

}
