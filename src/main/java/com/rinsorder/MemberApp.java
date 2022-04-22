package com.rinsorder;

import com.rinsorder.member.*;

public class MemberApp {

    public static void main(String[] args) {
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member = new Member(1L, Grade.VIP, "surin");
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = : " + findMember);
        System.out.println("findMember = : " + member);
    }
}
