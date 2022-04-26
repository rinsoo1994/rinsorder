package com.rinsorder.singleton;

import com.rinsorder.AppConfig;
import com.rinsorder.member.MemberRepository;
import com.rinsorder.member.MemberServiceImpl;
import com.rinsorder.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("메모리멤버레포지토리는 과연 싱글톤인가 아닌것인가")
    void memoryMemberRepositorySingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);

        // 모두 같은 인스턴스라는 것을 알 수 있다.
        System.out.println(memberRepository1);
        System.out.println(memberRepository2);
        System.out.println(memberRepository);
    }

    @Test
    void configurationDepp() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());
    }
}
