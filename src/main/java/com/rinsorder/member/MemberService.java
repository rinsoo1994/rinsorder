package com.rinsorder.member;

import com.rinsorder.member.Member;

import java.util.Optional;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
