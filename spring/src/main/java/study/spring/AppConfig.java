package study.spring;

import study.spring.discount.DiscountPolicy;
import study.spring.discount.RateDiscountPolicy;
import study.spring.member.MemberRepository;
import study.spring.member.MemberService;
import study.spring.member.MemberServiceImpl;
import study.spring.member.MemoryMemberRepository;
import study.spring.order.OrderService;
import study.spring.order.OrderServiceImpl;

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
