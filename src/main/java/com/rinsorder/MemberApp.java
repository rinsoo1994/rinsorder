package com.rinsorder;

import com.rinsorder.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L, Grade.VIP, "surin");
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = : " + findMember.getName());
        System.out.println("findMember = : " + member.getName());
    }
}
