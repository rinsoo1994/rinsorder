package com.rinsorder;

import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.discount.FixDiscountPolicy;
import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.MemberRepository;
import com.rinsorder.member.MemberService;
import com.rinsorder.member.MemberServiceImpl;
import com.rinsorder.member.MemoryMemberRepository;
import com.rinsorder.order.OrderService;
import com.rinsorder.order.OrderServiceImpl;

public class AppConfig {
    // OCP, SRP, DIP를 위반하지 않도록 하는 AppConfig

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
