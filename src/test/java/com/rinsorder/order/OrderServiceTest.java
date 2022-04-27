package com.rinsorder.order;

import com.rinsorder.AppConfig;
import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

class OrderServiceTest {

    // DI 객체 주입
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        // 맴버 객체 회원가입
        Member member = new Member(1L, Grade.VIP, "rinsoo");
        memberService.join(member);

        // order display
        Order order = orderService.createOrder(member.getId(), "display", 300000);
        System.out.println(order.caculatePrice());
        System.out.println(order);
        Assertions.assertThat(order.caculatePrice()).isEqualTo(270000);
    }
}