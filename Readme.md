# RewardCentral
API REST micro-service for TourGuide application to managing travel and attraction for a custumer.
TripPricer manage trip price informations. 
This app use SPRINT BOOT, FeignClient.

## Getting Started

- Endpoint : http://localhost:8084/
- Or : http://trippricer:8084/

## Prerequisites

- Java 1.8  or later
- Spring Boot 2.2.6
- Gradle 2.2.5
- Docker 2.5.0.0 (Optional)

# Installation

## No Database creation needed
## Without Docker
To start the application whitout docker start sub-micro-service with or without docker in build libs directories: 
- TripPricer : java -jar tripPricer-0.0.1-SNAPSHOT.jar

## With Docker
Docker construction in project directory : 
- docker build --build-arg JAR_FILE=build/libs/*.jar -t trippricer .

Docker execution : 
- docker run -p 8084:8084 --name TripPricer trippricer

# Architecture Diagram
![ScreenShot](Architecture.png)

# URI
## Get Price
Example : 
http://localhost:8084/getPrice?apiKey=abc&attractionId=123e4567-e89b-12d3-a456-426614174000&adults=2&children=2&nightsStay=5&rewardsPoints=10


## get Provider Name
Example : 
http://localhost:8084/getProviderName?apiKey=abc&adults=2