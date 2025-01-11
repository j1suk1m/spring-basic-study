package study.spring.autowired;

import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.member.Member;

class AutowiredTest {

    @Test
    void 자동_주입_옵션_테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNotRequiredMember(Member member) {
            System.out.println("Not required member = " + member);
        }
        
        @Autowired
        public void setNullableMember(@Nullable Member member) {
            System.out.println("Nullable member = " + member);
        }
        
        @Autowired
        public void setOptionalMember(Optional<Member> member) {
            System.out.println("Optional member = " + member);
        }

    }

}
