package ru.web.smart_soft_test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.web.smart_soft_test.domain.UserAction;
import ru.web.smart_soft_test.service.UserActionService;

import java.util.List;
import java.util.Map;

@Controller
public class LastHourController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LastHourController.class);

    @Autowired
    private UserActionService service;

    @RequestMapping(value = "/lastHour", method = RequestMethod.GET)
    public ModelAndView getUpload() {
        LOGGER.info("getUpload called");
        ModelAndView modelAndView = new ModelAndView("lastHour");
        Map<String, List<UserAction>> map = service.getLastHourActivity();
        modelAndView.addObject("map", map);
        return modelAndView;
    }
}
