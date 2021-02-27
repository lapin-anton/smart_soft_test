package ru.web.smart_soft_test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.web.smart_soft_test.domain.Form;
import ru.web.smart_soft_test.repository.FormRepository;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    private FormRepository repository;

    @Override
    public List<Form> getTopFiveForms() {
        LOGGER.info("getTopFiveForms called");
        return repository.getTopFiveForms();
    }
}
