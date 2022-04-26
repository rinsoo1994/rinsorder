package com.rinsorder.singleton;

import com.rinsorder.AppConfig;
import com.rinsorder.member.MemberService;
import com.rinsorder.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인 가능
        // 고객 트래픽이 초당 100이 나오면 초당 100개의 객체가 생성 및 소멸이 된다 -> 메모리 낭비가 심하게 된다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonInstance1 = SingletonService.getInstance();
        SingletonService singletonInstance2 = SingletonService.getInstance();

        System.out.println(singletonInstance1 + "" +  singletonInstance2);
        Assertions.assertThat(singletonInstance2).isSameAs(singletonInstance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void singletonContainerTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService1 = ac.getBean(OrderService.class);
        OrderService orderService2 = ac.getBean(OrderService.class);
        Assertions.assertThat(orderService1).isSameAs(orderService2);
    }
}
