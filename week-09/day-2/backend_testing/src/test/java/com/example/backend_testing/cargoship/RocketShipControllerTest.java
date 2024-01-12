package com.example.backend_testing.cargoship;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RocketShipControllerTest {

    @Autowired
    MockMvc mockMvc;


    RocketShipRepo rocketShipRepo;

    @Test
    void shipInfo() throws Exception {

        RocketShip fakeShip = new RocketShip();
        fakeShip.setCaliber50(2500);
        fakeShip.setCaliber30(5000);
        fakeShip.setCaliber25(5000);
        rocketShipRepo.save(fakeShip);
        fakeShip.getShipStatus(fakeShip);
        fakeShip.shipReadiness();

        Mockito.when(rocketShipRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(fakeShip));


        mockMvc.perform(MockMvcRequestBuilders.get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.caliber50").value("2500"))
                .andExpect(jsonPath("$.caliber25").value("5000"))
                .andExpect(jsonPath("$.caliber30").value("5000"))
                .andExpect(jsonPath("$.cargo").value("12500"))
                .andExpect(jsonPath("$.status").value("full"))
                .andExpect(jsonPath("$.ready").value("true"));

    }

    @Test
    void fillCargo() {
    }
}