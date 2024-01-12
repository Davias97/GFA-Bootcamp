package com.example.rest.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table (name = "entries")
public class Log {

    @Id
    @GeneratedValue
    private long id;
    private Timestamp createdAt;
    private String endpoint;
    private String data;

    public Log(String endpoint, String data) {
        this.endpoint = endpoint;
        this.data = data;
        this.createdAt = Timestamp.from(Instant.now());
    }

    public Log() {

    }
    public Log(String endpoint, Object data) throws JsonProcessingException {
        this.endpoint = endpoint;
        this.createdAt = Timestamp.from(Instant.now());
        ObjectMapper om = new ObjectMapper();
        this.data = om.writeValueAsString(data);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
