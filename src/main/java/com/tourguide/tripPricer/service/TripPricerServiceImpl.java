package com.tourguide.tripPricer.service;

import com.tourguide.tripPricer.externalModule.ExtModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@Service
public class TripPricerServiceImpl implements TripPricerService {
    @Autowired
    private ExtModule extModule;

    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        return extModule.getPrice( apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
    }

    @Override
    public String getProviderName(String apiKey, int adults) {
        return extModule.getProviderName(apiKey, adults);
    }
}
