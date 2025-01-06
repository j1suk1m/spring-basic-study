package study.java;

import study.java.member.Grade;
import study.java.member.Member;
import study.java.member.MemberService;
import study.java.member.MemberServiceImpl;

public class MemberApplication {
    public static void main(String[] args) {
        Long id = 1L;
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(id, "member A", Grade.VIP);

        memberService.join(member);
        Member foundMember = memberService.findMember(id);

        System.out.println("member.getName() = " + member.getName());
        System.out.println("foundMember.getName() = " + foundMember.getName());
    }
}
