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
public class UnfinishedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnfinishedController.class);

    @Autowired
    private UserActionService service;

    @RequestMapping(value = "/unfinished", method = RequestMethod.GET)
    public ModelAndView getUnfinished() {
        LOGGER.info("getUnfinished called");
        ModelAndView modelAndView = new ModelAndView("unfinished");
        Map<String, UserAction> map = service.getUnfinished();
        modelAndView.addObject("map", map);
        return modelAndView;
    }

}