package ru.trainee.adminpanel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.repository.ActionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;

    public void saveAction(Action action) throws Exception{
        actionRepository.save(action);
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }
}
