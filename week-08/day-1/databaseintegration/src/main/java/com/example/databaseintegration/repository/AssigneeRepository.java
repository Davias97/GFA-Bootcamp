package com.example.databaseintegration.repository;

import com.example.databaseintegration.model.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findAll();
}
