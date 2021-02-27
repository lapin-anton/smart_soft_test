package ru.web.smart_soft_test.service;

import ru.web.smart_soft_test.domain.UserAction;

import java.util.List;
import java.util.Map;

public interface UserActionService {
    void createUserAction(List<String[]> params) throws Exception;
    Map<String, List<UserAction>> getLastHourActivity();
    Map<String, UserAction> getUnfinished();
}
