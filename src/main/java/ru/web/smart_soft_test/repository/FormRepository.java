package ru.web.smart_soft_test.repository;

import ru.web.smart_soft_test.domain.Form;

import java.util.List;

public interface FormRepository {
    List<Form> getTopFiveForms();
}
