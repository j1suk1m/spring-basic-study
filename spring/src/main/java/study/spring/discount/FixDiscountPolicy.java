package study.spring.discount;

import study.spring.member.Grade;
import study.spring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        }

        return 0;
    }
}
