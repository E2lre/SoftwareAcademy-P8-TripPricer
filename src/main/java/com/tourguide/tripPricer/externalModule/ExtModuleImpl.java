package com.tourguide.tripPricer.externalModule;

import org.springframework.stereotype.Repository;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

@Repository
public class ExtModuleImpl implements ExtModule {
    private static TripPricer  tripPricer = new TripPricer();

    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        return tripPricer.getPrice( apiKey,  attractionId,  adults,  children,  nightsStay,  rewardsPoints);
    }

    @Override
    public String getProviderName(String apiKey, int adults) {
        return tripPricer.getProviderName(apiKey,adults);
    }

}
