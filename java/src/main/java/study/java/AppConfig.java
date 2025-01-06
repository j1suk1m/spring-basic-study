package study.java;

import study.java.discount.RateDiscountPolicy;
import study.java.member.MemberService;
import study.java.member.MemberServiceImpl;
import study.java.member.MemoryMemberRepository;
import study.java.order.OrderService;
import study.java.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
