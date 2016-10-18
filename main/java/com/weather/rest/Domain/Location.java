package com.weather.rest.Domain;

/**
 * Created by Leo on 03/10/2016.
 */
public class Location {
    private String city;
    private String country;
    private String region;

    private Location(String city, String country, String region) {

        this.city = city;
        this.country = country;
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public static class LocationBuilder {
        private String city;
        private String country;
        private String region;

        public LocationBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public LocationBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public LocationBuilder setRegion(String region) {
            this.region = region;
            return this;
        }

        public Location createLocation() {
            return new Location(city, country, region);
        }

        public Location createDefaultLocation() {
            return new Location("Cordoba", "Argentina", "Centro");
        }
    }
}
