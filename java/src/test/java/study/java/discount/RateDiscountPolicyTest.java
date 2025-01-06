package study.java.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.java.member.Grade;
import study.java.member.Member;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원은 10% 할인이 적용되어야 한다.")
    void VIP_회원_정률_할인_적용_테스트() {
        // given
        int itemPrice = 20000;
        int discountPercent = discountPolicy.getDiscountPercent();
        Member member = new Member(1L, "member A", Grade.VIP);

        // when
        int discountAmount = discountPolicy.discount(member, itemPrice);

        // then
        Assertions.assertThat(discountAmount).isEqualTo(itemPrice * discountPercent / 100);
    }

    @Test
    @DisplayName("일반 회원은 10% 할인이 적용되지 않아야 한다.")
    void 일반_회원_정률_할인_미적용_테스트() {
        // given
        int itemPrice = 20000;
        Member member = new Member(2L, "member B", Grade.BASIC);

        // when
        int discountAmount = discountPolicy.discount(member, itemPrice);

        // then
        Assertions.assertThat(discountAmount).isZero();
    }
}