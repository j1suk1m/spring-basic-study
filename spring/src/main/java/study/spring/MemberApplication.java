package study.spring;

import study.spring.member.Grade;
import study.spring.member.Member;
import study.spring.member.MemberService;

public class MemberApplication {
    public static void main(String[] args) {
        Long id = 1L;
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(id, "member A", Grade.VIP);

        memberService.join(member);
        Member foundMember = memberService.findMember(id);

        System.out.println("member.getName() = " + member.getName());
        System.out.println("foundMember.getName() = " + foundMember.getName());
    }
}
