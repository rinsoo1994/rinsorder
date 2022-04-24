package com.rinsorder;

import com.rinsorder.discount.RateDiscountPolicy;
import com.rinsorder.member.*;
import com.rinsorder.order.Order;
import com.rinsorder.order.OrderService;
import com.rinsorder.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        // DI를 통한 의존성 주입
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // 맴버 객체 회원가입
        Member member = new Member(1L, Grade.VIP, "rinsoo");
        memberService.join(member);

        // order display
        Order order = orderService.createOrder(member.getId(), "display", 300000);
        System.out.println(order.caculatePrice());
        System.out.println(order);
    }
}
