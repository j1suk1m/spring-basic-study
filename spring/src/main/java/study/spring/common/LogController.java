package study.spring.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    private final Logger logger;

    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        logger.setRequestURL(requestURL);

        logger.log("controller test");
        logService.executeLogic("testId");

        return "OK";
    }
}