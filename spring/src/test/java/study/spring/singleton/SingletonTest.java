package study.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.spring.AppConfig;
import study.spring.member.MemberService;

class SingletonTest {

    @Test
    void 스프링_없는_순수_DI_컨테이너_싱글톤_미적용_테스트() {
        // given
        AppConfig appConfig = new AppConfig();

        // when
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // then
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

}
