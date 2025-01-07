package study.java;

import study.java.discount.DiscountPolicy;
import study.java.discount.RateDiscountPolicy;
import study.java.member.MemberRepository;
import study.java.member.MemberService;
import study.java.member.MemberServiceImpl;
import study.java.member.MemoryMemberRepository;
import study.java.order.OrderService;
import study.java.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
