package study.spring.discount;

import study.spring.member.Grade;
import study.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private final int discountPercent = 10;

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}