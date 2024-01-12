package com.example.databaseintegration.repository;


import com.example.databaseintegration.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findTodosByTitleContainsIgnoreCaseAndUrgentAndDone(@Param("title") String todoTitle,
                                                                 @Param("urgent") Boolean todoUrgent,
                                                                 @Param("done") Boolean todoDone);
    List<Todo> findAll();
}
