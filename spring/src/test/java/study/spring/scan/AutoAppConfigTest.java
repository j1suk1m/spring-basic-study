package study.spring.scan;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.AutoAppConfig;
import study.spring.member.MemberService;

class AutoAppConfigTest {

    @Test
    void 기본_컴포넌트_스캔_테스트() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        // when
        MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("memberService", MemberService.class));
    }

}