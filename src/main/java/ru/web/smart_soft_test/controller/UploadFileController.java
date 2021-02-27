package ru.web.smart_soft_test.controller;

import au.com.bytecode.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.web.smart_soft_test.service.UserActionService;

import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class UploadFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private UserActionService service;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String getUpload() {
        LOGGER.info("getUpload called");
        return "upload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ModelAndView handleUploadedFile(@RequestParam(value = "file") Part file) {
        LOGGER.info("handleUploadedFile called");
        ModelAndView modelAndView = new ModelAndView("upload");

        if((file != null) || (file.getSubmittedFileName().endsWith(".csv"))) {
            try (CSVReader reader = new CSVReader(new BufferedReader
                    (new InputStreamReader(file.getInputStream())), ';', '"', 1)) {
                List<String[]> params = reader.readAll();
                service.createUserAction(params);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            LOGGER.info("Uploaded file is null");
            modelAndView.addObject("message", "Не удалось загрузить файл.");
        }
        return modelAndView;
    }
}
