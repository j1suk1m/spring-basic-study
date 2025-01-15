package study.spring.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    private final ObjectProvider<Logger> loggerProvider;

    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request) {
        Logger logger = loggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        logger.setRequestURL(requestURL);

        logger.log("controller test");
        logService.executeLogic("testId");

        return "OK";
    }
}