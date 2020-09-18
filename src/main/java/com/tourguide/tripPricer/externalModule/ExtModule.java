package com.tourguide.tripPricer.externalModule;

import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

public interface ExtModule {
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints);
    public String getProviderName(String apiKey, int adults);
}
