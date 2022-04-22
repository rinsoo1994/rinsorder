package com.rinsorder.order;

import com.rinsorder.discount.DiscountPolicy;
import com.rinsorder.discount.FixDiscountPolicy;
import com.rinsorder.member.*;

public class OrderServiceImpl implements OrderService{

    // final을 사용한다는것..
    // 고쳐야할때? 이부분을 고쳐야하는데 코드를 고쳐야 하는 문제가 발생. Autowired 로 가능?
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
