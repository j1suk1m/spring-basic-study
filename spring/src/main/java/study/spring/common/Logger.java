package study.spring.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.UUID;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Logger {

    @Setter
    private String requestURL;
    private String uuid;

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] Create request scope bean: " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[" + uuid + "] Close request scope bean: " + this);
    }

}