package com.example.backend_testing.cargoship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class RocketShip {

    @Id
    @GeneratedValue
    private Long id;

    private int caliber25 = 0;
    private int caliber30 = 0;
    private int caliber50 = 0;
    private int cargo;
    private String status;
    private boolean ready = false;


    private RocketShipRepo rocketShipRepo;

    public RocketShip() {
    }

    public RocketShip(int caliber25, int caliber30, int caliber50) {
        this.caliber25 = caliber25;
        this.caliber30 = caliber30;
        this.caliber50 = caliber50;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCaliber25() {
        return caliber25;
    }

    public void setCaliber25(int caliber25) {
        this.caliber25 = caliber25;
    }

    public int getCaliber30() {
        return caliber30;
    }

    public void setCaliber30(int caliber30) {
        this.caliber30 = caliber30;
    }

    public int getCaliber50() {
        return caliber50;
    }

    public void setCaliber50(int caliber50) {
        this.caliber50 = caliber50;
    }

    public String isShipstatus() {
        return status;
    }

    public void setShipstatus(String shipstatus) {
        this.status = shipstatus;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getCargo() {
        return cargo = caliber30 + caliber25 + caliber50;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public RocketShip saveShip(RocketShip ship) {
        return rocketShipRepo.save(ship);
    }

    public void getShipStatus(RocketShip ship) {
        RocketShipRepo rocketShipRepo;
        Integer shipStatus = ship.getCargo() / 125;

        if (shipStatus == 100) {
            ship.setShipstatus("full");
        } else if (shipStatus == 0) {
            ship.setShipstatus("empty");
        }
        ship.setShipstatus(shipStatus.toString() + "%");

        ship.saveShip(ship);
    }

    public boolean shipReadiness() {
        int cargo = getCargo();

        return cargo == 12500;
    }
}
