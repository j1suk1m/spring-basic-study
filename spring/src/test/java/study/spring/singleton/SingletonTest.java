package study.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    @Test
    void 싱글톤_적용_테스트() {
        // when
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // then
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    void 스프링_컨테이너_싱글톤_적용_테스트() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // then
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
