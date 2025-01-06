package study.java.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java.member.Grade;
import study.java.member.Member;
import study.java.member.MemberService;
import study.java.member.MemberServiceImpl;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void 주문_성공_테스트() {
        // given
        Long id = 1L;
        int itemPrice = 20000;
        int discountAmount = 1000;
        Member member = new Member(id, "member A", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(id, "item A", itemPrice);

        // then
        Assertions.assertThat(order.getDiscountAmount()).isEqualTo(discountAmount);
    }
}
