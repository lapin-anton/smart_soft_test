package ru.web.smart_soft_test.service;

import ru.web.smart_soft_test.domain.Form;

import java.util.List;

public interface FormService {
    List<Form> getTopFiveForms();
}
