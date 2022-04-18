package cn.edu.seu.lone.elk.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
public class LogController {

    @GetMapping("/logs")
    public String printLogs() {
        log.info(this.getClass().getSimpleName() + "info" + LocalDateTime.now().getSecond());
        return "logs";
    }
}
