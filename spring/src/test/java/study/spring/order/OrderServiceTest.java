package study.spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.AppConfig;
import study.spring.member.Grade;
import study.spring.member.Member;
import study.spring.member.MemberService;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    @Test
    void 주문_성공_테스트() {
        // given
        Long id = 1L;
        int itemPrice = 20000;
        int discountPercent = 10;
        int discountAmount = itemPrice * discountPercent / 100;
        Member member = new Member(id, "member A", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(id, "item A", itemPrice);

        // then
        Assertions.assertThat(order.getDiscountAmount()).isEqualTo(discountAmount);
    }
}
