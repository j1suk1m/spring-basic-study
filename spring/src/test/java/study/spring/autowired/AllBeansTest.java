package study.spring.autowired;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.AutoAppConfig;
import study.spring.discount.DiscountPolicy;
import study.spring.member.Grade;
import study.spring.member.Member;

public class AllBeansTest {

    @Test
    void 조회한_모든_빈_사용_테스트() {
        // given
        Member member = new Member(1L, "member A", Grade.VIP);
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        // when
        DiscountService discountService = ac.getBean(DiscountService.class);
        int fixDiscountAmount = discountService.discount(member, 20000, "fixDiscountPolicy");
        int rateDiscountAmount = discountService.discount(member, 20000, "rateDiscountPolicy");

        // then
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(fixDiscountAmount).isEqualTo(1000);
        Assertions.assertThat(rateDiscountAmount).isEqualTo(2000);
    }

    @RequiredArgsConstructor
    static class DiscountService {
        private final Map<String, DiscountPolicy> store;

        public int discount(Member member, int price, String discountPolicyType) {
            DiscountPolicy discountPolicy = store.get(discountPolicyType);
            return discountPolicy.discount(member, price);
        }
    }

}
