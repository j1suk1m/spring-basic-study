package study.java.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.java.AppConfig;
import study.java.member.Grade;
import study.java.member.Member;
import study.java.member.MemberService;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
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
