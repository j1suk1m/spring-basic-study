package study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.member.Grade;
import study.spring.member.Member;
import study.spring.member.MemberService;

public class MemberApplication {

    public static void main(String[] args) {
        Long id = 1L;
        Member member = new Member(id, "member A", Grade.VIP);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        memberService.join(member);
        Member foundMember = memberService.findMember(id);

        System.out.println("member.getName() = " + member.getName());
        System.out.println("foundMember.getName() = " + foundMember.getName());
    }

}
