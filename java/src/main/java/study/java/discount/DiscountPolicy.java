package study.java.discount;

import study.java.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
