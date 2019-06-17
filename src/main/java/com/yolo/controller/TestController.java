package com.yolo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public String test(Model model) {
        logger.info("test controller test method dziala?");
        return "dziala?";
    }
}
