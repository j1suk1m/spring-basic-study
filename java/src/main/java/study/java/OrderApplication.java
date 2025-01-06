package study.java;

import study.java.member.Grade;
import study.java.member.Member;
import study.java.member.MemberService;
import study.java.member.MemberServiceImpl;
import study.java.order.Order;
import study.java.order.OrderService;
import study.java.order.OrderServiceImpl;

public class OrderApplication {
    public static void main(String[] args) {
        Long id = 1L;
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        Member member = new Member(id, "member A", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(id, "item A", 20000);

        System.out.println("order = " + order);
    }
}
