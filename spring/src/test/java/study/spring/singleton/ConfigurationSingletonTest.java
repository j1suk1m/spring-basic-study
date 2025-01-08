package study.spring.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.AppConfig;
import study.spring.member.MemberRepository;
import study.spring.member.MemberServiceImpl;
import study.spring.order.OrderServiceImpl;

class ConfigurationSingletonTest {

    @Test
    void Configuration_싱글톤_적용_테스트() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // then
        assertThat(memberRepository1).isSameAs(memberRepository);
        assertThat(memberRepository2).isSameAs(memberRepository);
    }

}
