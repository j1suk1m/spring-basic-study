package study.spring.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

class SingletonBeanWithPrototypeBeanTest {

    @Test
    void 프로토타입_빈_조회_테스트() {

        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        // when
        prototypeBean1.addCount();

        // then
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        // given
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        // when
        prototypeBean2.addCount();

        // then
        assertThat(prototypeBean2.getCount()).isEqualTo(1);

    }

    @Test
    void 싱글톤_빈에서_프로토타입_빈_사용_테스트() {

        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);

        // when & then
        assertThat(clientBean1.executeLogic()).isEqualTo(1);

        // given
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        // when & then
        assertThat(clientBean2.executeLogic()).isEqualTo(1);

    }

    @RequiredArgsConstructor
    static class ClientBean {
        private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int executeLogic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {

        @Getter
        private int count = 0;

        public void addCount() {
            System.out.println("PrototypeBean.addCount");
            count++;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init: " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }

}