package com.rinsorder.beanfind;

import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.MemberRepository;
import com.rinsorder.member.MemberService;
import com.rinsorder.member.MemberServiceImpl;
import com.rinsorder.member.MemoryMemberRepository;
import com.rinsorder.order.OrderService;
import com.rinsorder.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("여러개 타입 조회 에러")
    void findSeveralTypeError() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemoryMemberRepository.class));
    }

    @Test
    @DisplayName("특정 타입 모두 조회하기")
    void findSeveralTypes() {
        Map<String, MemberRepository> beans = ac.getBeansOfType(MemberRepository.class);
        for (String s : beans.keySet()) {
            System.out.println("key: " + s + ", value: " + beans.get(s));
        }
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
        }

        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl(memberRepository(), discountPolicy());
        }

        @Bean
        public DiscountPolicy discountPolicy(){
            return new RateDiscountPolicy();
        }
    }
}
