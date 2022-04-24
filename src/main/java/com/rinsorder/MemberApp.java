package com.rinsorder;

import com.rinsorder.member.*;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // DI를 통해서 필요한 객체를 주입한다.
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, Grade.VIP, "surin");
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = : " + findMember.getName());
        System.out.println("findMember = : " + member.getName());
    }
}
