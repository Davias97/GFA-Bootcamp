package com.example.backend_testing.cargoship;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RocketShipRepo extends CrudRepository<RocketShip, Long> {

}
