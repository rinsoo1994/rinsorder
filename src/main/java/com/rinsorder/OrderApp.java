package com.rinsorder;

import com.rinsorder.member.*;
import com.rinsorder.order.Order;
import com.rinsorder.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 맴버 객체 회원가입
        Member member = new Member(1L, Grade.VIP, "rinsoo");
        memberService.join(member);

        // order display
        Order order = orderService.createOrder(member.getId(), "display", 300000);
        System.out.println(order.caculatePrice());
        System.out.println(order);
    }
}
