package ru.web.smart_soft_test.repository;

import ru.web.smart_soft_test.domain.UserAction;

import java.util.List;

public interface UserActionRepository {
    void createUserActon(List<UserAction> userActions);
    List<UserAction> getAllUserActions();
    List<UserAction> getUserActionsOnLastHour();
}
