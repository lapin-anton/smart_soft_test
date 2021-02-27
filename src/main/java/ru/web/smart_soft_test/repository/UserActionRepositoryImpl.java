package ru.web.smart_soft_test.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.web.smart_soft_test.domain.UserAction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {java.lang.Exception.class})
public class UserActionRepositoryImpl implements UserActionRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUserActon(List<UserAction> userActions) {
        try {
            LocalTime start = LocalTime.now();
            LOGGER.info("Data recording started");
            AtomicLong counter = new AtomicLong(0L);
            userActions.forEach(ua -> {
                entityManager.persist(ua);
                counter.getAndIncrement();
                if (counter.get() % 10000L == 0) {
                    LOGGER.info(String.format("Added %d lines", counter.get()));
                }
            });
            entityManager.flush();
            LocalTime finish = LocalTime.now();
            long seconds = finish.getSecond() - start.getSecond();
            LOGGER.info(String.format("Data recording finished. Duration: %d seconds", seconds));
        } catch (Exception e) {
            LOGGER.error(String.format("%s", e.getMessage()));
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserAction> getAllUserActions() {
        return entityManager
                .createNamedQuery("UserAction.findAllUserActions")
                .getResultList();
    }

    @Override
    public List<UserAction> getUserActionsOnLastHour() {
        return entityManager
                .createNamedQuery("UserAction.findUserActionsOnLastHour")
                .getResultList();
    }
}
