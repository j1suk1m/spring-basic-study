package study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.member.Grade;
import study.spring.member.Member;
import study.spring.member.MemberService;
import study.spring.order.Order;
import study.spring.order.OrderService;

public class OrderApplication {

    public static void main(String[] args) {
        Long id = 1L;
        Member member = new Member(id, "member A", Grade.VIP);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        memberService.join(member);
        Order order = orderService.createOrder(id, "item A", 20000);

        System.out.println("order = " + order);
    }

}
