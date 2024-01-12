package com.example.backend_testing.cargoship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketShipController {

    @Autowired
    RocketShipRepo rocketShipRepo;

    public RocketShipController(RocketShipRepo rocketShipRepo) {
        this.rocketShipRepo = rocketShipRepo;
    }

    @GetMapping("/rocket")
    public ResponseEntity<RocketShip> shipInfo() {

        RocketShip rocketShip = rocketShipRepo.findById(1L).orElse(new RocketShip());

        return ResponseEntity.ok(rocketShip);
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<RocketShip> fillCargo(@RequestParam String caliber, @RequestParam int amount) {

        RocketShip rocketShip = rocketShipRepo.findById(1L).orElse(new RocketShip());

        switch (caliber) {
            case ".25" -> rocketShip.setCaliber25(amount);
            case ".30" -> rocketShip.setCaliber30(amount);
            case ".50" -> rocketShip.setCaliber50(amount);
        }

        return ResponseEntity.ok(rocketShip);
    }
}
