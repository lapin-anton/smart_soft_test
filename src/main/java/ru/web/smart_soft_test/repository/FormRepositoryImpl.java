package ru.web.smart_soft_test.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.web.smart_soft_test.domain.Form;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FormRepositoryImpl implements FormRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormRepositoryImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Form> getTopFiveForms() {
        LOGGER.info("getTopFiveForms called");
        return entityManager
                .createNamedQuery("Form.findTopFiveForms")
                .getResultList();
    }
}
