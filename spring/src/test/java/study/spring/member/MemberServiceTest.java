package study.spring.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.AppConfig;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    void 회원_가입_성공_테스트() {
        // given
        Long id = 1L;
        Member member = new Member(id, "member A", Grade.VIP);

        // when
        memberService.join(member);
        Member foundMember = memberService.findMember(id);

        // then
        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}
