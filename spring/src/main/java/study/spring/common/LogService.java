package study.spring.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final Logger logger;

    public void executeLogic(String id) {
        logger.log("service id = " + id);
    }
}