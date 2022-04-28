package com.rinsorder.order;

import com.rinsorder.annotation.MainDiscountPolicy;
import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    // final 을 사용한다는것..
    // 고쳐야할때? 이부분을 고쳐야하는데 코드를 고쳐야 하는 문제가 발생. Autowired 로 가능?
    // TODO: 두가지 구현체를 모두 사용할때는 근데 스프링 컨테이너가 어떤건지 어떻게 알지?
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("setMemberRepository");
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("setDiscountPolicy");
//        this.discountPolicy = discountPolicy;
//    }

//    // 생성자가 이렇게 하나인 경우에는 Autowired 애노테이션 넣어도 되고 안넣어도 됨
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // For test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
