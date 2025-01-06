package study.java;

import study.java.member.Grade;
import study.java.member.Member;
import study.java.member.MemberService;
import study.java.order.Order;
import study.java.order.OrderService;

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
