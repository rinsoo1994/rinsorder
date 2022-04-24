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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // OCP, SRP, DIP를 위반하지 않도록 하는 AppConfig

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl( memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
