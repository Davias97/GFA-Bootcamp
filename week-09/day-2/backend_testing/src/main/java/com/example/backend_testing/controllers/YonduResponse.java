package com.example.backend_testing.controllers;

public class YonduResponse {
    private Double distance;
    private Double time;
    private Double speed;

    public YonduResponse(Double distance, Double time) {
        this.distance = distance;
        this.time = time;
        this.speed = distance / time;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
