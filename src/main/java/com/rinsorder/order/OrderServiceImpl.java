package com.rinsorder.order;

import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.member.*;

public class OrderServiceImpl implements OrderService{

    // final을 사용한다는것..
    // 고쳐야할때? 이부분을 고쳐야하는데 코드를 고쳐야 하는 문제가 발생. Autowired 로 가능?
    // 두가지 구현체를 모두 사용할때는 근데 스프링 컨테이너가 어떤건지 어떻게 알지?
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
