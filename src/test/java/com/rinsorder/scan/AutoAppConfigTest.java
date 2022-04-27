package com.rinsorder.scan;

import com.rinsorder.AutoAppConfig;
import com.rinsorder.member.MemberService;
import com.rinsorder.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        System.out.println("here i am");
        MemberService memberBean = ac.getBean(MemberService.class);
        Assertions.assertThat(memberBean).isInstanceOf(MemberService.class);
    }
}
