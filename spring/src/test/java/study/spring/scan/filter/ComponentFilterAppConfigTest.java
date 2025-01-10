package study.spring.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

    @Test
    void 필터_스캔_테스트() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        // when
        IncludedBean includedBean = ac.getBean("includedBean", IncludedBean.class);

        // then
        assertThat(includedBean).isNotNull();
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("excludedBean", ExcludedBean.class));

    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = IncludedComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = ExcludedComponent.class)
    )
    static class ComponentFilterAppConfig {
    }
}
