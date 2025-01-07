package study.spring.discount;

import study.spring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
