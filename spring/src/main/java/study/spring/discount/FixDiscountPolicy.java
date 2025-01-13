package study.spring.discount;

import org.springframework.stereotype.Component;
import study.spring.member.Grade;
import study.spring.member.Member;

@Component
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
