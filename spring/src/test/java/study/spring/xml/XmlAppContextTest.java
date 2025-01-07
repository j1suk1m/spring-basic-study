package study.spring.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import study.spring.member.MemberService;

class XmlAppContextTest {

    @Test
    void Xml_설정_파일_적용_시_빈_조회_성공_테스트() {
        // given
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        // when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
