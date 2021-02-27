package ru.web.smart_soft_test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.web.smart_soft_test.domain.Form;
import ru.web.smart_soft_test.service.FormService;
import ru.web.smart_soft_test.service.UserActionService;

import java.util.List;

@Controller
public class TopFiveFormsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopFiveFormsController.class);

    @Autowired
    private FormService service;

    @RequestMapping(value = "/topFiveForms", method = RequestMethod.GET)
    public ModelAndView getTopFiveForms() {
        LOGGER.info("getTopFiveForms called");
        ModelAndView modelAndView = new ModelAndView("topFiveForms");
        List<Form> forms = service.getTopFiveForms();
        modelAndView.addObject("forms", forms);
        return modelAndView;
    }
}
