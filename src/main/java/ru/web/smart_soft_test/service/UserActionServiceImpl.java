package ru.web.smart_soft_test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.web.smart_soft_test.domain.UserAction;
import ru.web.smart_soft_test.repository.UserActionRepository;
import ru.web.smart_soft_test.util.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserActionServiceImpl implements UserActionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActionServiceImpl.class);

    @Autowired
    private UserActionRepository repository;

    @Autowired
    private LocalDateTimeAdapter adapter;

    @Override
    public void createUserAction(List<String[]> params) {
        LOGGER.info("createUserAction called");
        List<UserAction> userActions = new LinkedList<>();
        for (String[] p: params) {
            try {
                UserAction userAction = new UserAction();
                userAction.setSsoId(p[0]);
                userAction.setTs(Long.parseLong(p[1]));
                userAction.setGrp(p[2]);
                userAction.setType(p[3]);
                userAction.setSubtype(p[4]);
                userAction.setUrl(p[5]);
                userAction.setOrgId(p[6]);
                userAction.setFormId(p[7]);
                userAction.setCode(p[8]);
                userAction.setLtpa(p[9]);
                userAction.setSudirresponse(p[10]);
                userAction.setYdmh(adapter.unmarshal(p[11]));
                userActions.add(userAction);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                continue;
            }
        }
        repository.createUserActon(userActions);
    }

    @Override
    public Map<String, List<UserAction>> getLastHourActivity() {
        LOGGER.info("getLastHourActivity called");
        List<UserAction> actions = repository.getUserActionsOnLastHour();
        Map<String, List<UserAction>> map = new HashMap<>();
        actions.forEach(userAction -> {
            List<UserAction> userActions;
            if(userAction != null && !userAction.getSsoId().equals("")) {
                if (map.containsKey(userAction.getSsoId())) {
                    userActions = map.get(userAction.getSsoId());
                } else {
                    userActions = new LinkedList<>();
                }
                if((userAction.getUrl() != null && !userAction.getUrl().equals(""))
                    && (userAction.getFormId() != null && !userAction.getFormId().equals(""))) {
                    userActions.add(userAction);
                    map.put(userAction.getSsoId(), userActions);
                }
            }
        });
        return map;
    }

    @Override
    public Map<String, UserAction> getUnfinished() {
        LOGGER.info("getUnfinished called");
        List<UserAction> actions = repository.getAllUserActions();
        Map<String, UserAction> map = new HashMap<>();
        actions.forEach(userAction -> {
            if(userAction != null && !userAction.getSsoId().equals("")) {
                if((userAction.getUrl() != null && !userAction.getUrl().equals(""))
                        && (userAction.getFormId() != null && !userAction.getFormId().equals(""))
                        && (!userAction.getSubtype().trim().equals("send")) &&
                           (!userAction.getSubtype().trim().equals("sent")) &&
                           (!userAction.getSubtype().trim().equals("done")) &&
                           (!userAction.getSubtype().trim().equals("success")) &&
                            (!userAction.getGrp().endsWith("uccess"))) {
                    map.put(userAction.getSsoId(), userAction);
                } else {
                    if(map.containsKey(userAction.getSsoId())) {
                        map.remove(userAction.getSsoId());
                    }
                }
            }
        });
        return map;
    }
}
