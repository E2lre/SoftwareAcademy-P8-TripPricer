package com.tourguide.tripPricer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;
import java.util.UUID;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestTripPricerControlerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrice_correctInput_OkIsReturn() throws Exception {
        //GIVEN : for correct inputs
        String apiKey="test-server-api-key";
        UUID attractionId=UUID.randomUUID();
        int adults=2;
        int children=1;
        int nightsStay=5;
        int rewardsPoints=5;

        //WHEN call Controller
        //THEN return is OK
        mockMvc.perform(get("/getPrice?apiKey="+apiKey+"&attractionId=" + attractionId+"&adults=" + adults+"&children=" + children+"&nightsStay=" + nightsStay+"&rewardsPoints=" + rewardsPoints))
                .andExpect(status().isOk());
    }

    @Test
    public void getProviderName_correctInput_OkIsReturn() throws Exception {
        //GIVEN : for correct inputs
        String apiKey="test-server-api-key";
        int adults=2;

        //WHEN call Controller
        //THEN return is OK
        mockMvc.perform(get("/getProviderName?apiKey="+apiKey+"&adults=" + adults))
                .andExpect(status().isOk());
    }
}
