package study.spring;

import study.spring.member.Grade;
import study.spring.member.Member;
import study.spring.member.MemberService;
import study.spring.order.Order;
import study.spring.order.OrderService;

public class OrderApplication {
    public static void main(String[] args) {
        Long id = 1L;
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Member member = new Member(id, "member A", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(id, "item A", 20000);

        System.out.println("order = " + order);
    }
}
