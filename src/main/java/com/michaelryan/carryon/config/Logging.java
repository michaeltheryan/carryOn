package com.michaelryan.carryon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class defines the configuration for logging transactions, requests, and
 * responses to a local file
 */
@Slf4j
@RestController
public class Logging {

    /**
     * This method defines the logging lines that accompany various types
     * of log entries
     */
    @RequestMapping("/lombok")
    public String makeLogs() {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
        return "Review logs...";
    }
}
