package study.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring.discount.DiscountPolicy;
import study.spring.discount.RateDiscountPolicy;
import study.spring.member.MemberRepository;
import study.spring.member.MemberService;
import study.spring.member.MemberServiceImpl;
import study.spring.member.MemoryMemberRepository;
import study.spring.order.OrderService;
import study.spring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
