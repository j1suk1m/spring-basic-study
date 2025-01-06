package study.java.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.java.AppConfig;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
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
