package com.example.rest.services;

import com.example.rest.models.Log;
import com.example.rest.repo.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(Log log) {
        logRepository.save(log);
    }

    public List<Log> listLogs() {
        return logRepository.findAll();
    }

}
