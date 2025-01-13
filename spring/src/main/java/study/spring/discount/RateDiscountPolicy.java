package study.spring.discount;

import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import study.spring.annotation.MainDiscountPolicy;
import study.spring.member.Grade;
import study.spring.member.Member;

@Component
@Primary
@MainDiscountPolicy
@Getter
public class RateDiscountPolicy implements DiscountPolicy {
    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}