package com.example.databaseintegration.service;

import com.example.databaseintegration.model.Assignee;
import com.example.databaseintegration.repository.AssigneeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeService {

    private AssigneeRepository assigneeRepository;

    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public void saveAssignee(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    public List<Assignee> listAssignees() {
        return assigneeRepository.findAll();
    }

    public void deleteAssignee(Long id) {
        assigneeRepository.deleteById(id);
    }
}
