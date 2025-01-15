package study.spring.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final ObjectProvider<Logger> loggerProvider;

    public void executeLogic(String id) {
        Logger logger = loggerProvider.getObject();
        logger.log("service id = " + id);
    }
}