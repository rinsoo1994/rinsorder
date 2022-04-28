package com.rinsorder.scan.allbean;

import com.rinsorder.AutoAppConfig;
import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.member.Grade;
import com.rinsorder.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, Grade.VIP, "USERA");
        // Strategy Pattern 을 사용한 개발!
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        System.out.println(discountPrice);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println(policyMap);
            System.out.println(policies);
        }

        public int discount(Member member, int price, String discountPolicy) {
            return policyMap.get(discountPolicy).discount(member, price);
        }
    }
}
