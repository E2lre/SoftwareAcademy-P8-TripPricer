package com.tourguide.tripPricer.controler;

import com.tourguide.tripPricer.controler.exceptions.UUIDException;
import com.tourguide.tripPricer.service.TripPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerControler {
    private Logger logger = LoggerFactory.getLogger(TripPricerControler.class);
    @Autowired
    private TripPricerService tripPricerService;

    /**
     * give a price for an attraction
     * @param apiKey api key
     * @param attractionId attraction uuid
     * @param adults number of adults
     * @param children number of children
     * @param nightsStay number of night in attraction
     * @param rewardsPoints reward point for the user
     * @return list of providers
     * @throws UUIDException id uuid is incorrect
     */
    @GetMapping(value = "getPrice")
    @ResponseStatus(HttpStatus.OK)
    public List<Provider> getPrice (@RequestParam String apiKey,@RequestParam UUID attractionId,@RequestParam int adults,@RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints) throws UUIDException {
        /*try {*/
            logger.info("Start getPrice for apiKey : " + apiKey +" et attractionId : " +attractionId );
            //UUID attractionId = UUID.fromString(attractionId);
            return tripPricerService.getPrice(apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
        /*} catch (Exception e){
            throw new UUIDException("UUID input error : attractionId = " + attractionId + "  message :" + e.getMessage());
        }*/
    }

    /**
     * give the name of the provider
     * @param apiKey api key
     * @param adults provider id
     * @return name of the provider
     */
    @GetMapping(value = "getProviderName")
    @ResponseStatus(HttpStatus.OK)
    public String getProviderName (@RequestParam String apiKey,@RequestParam int adults)  {
        logger.info("Start getProviderName for apiKey : " + apiKey +" et adults : " +adults );
            return tripPricerService.getProviderName(apiKey,  adults);

    }

}
