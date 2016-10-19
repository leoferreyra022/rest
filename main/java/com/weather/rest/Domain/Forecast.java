package com.weather.rest.Domain;

import java.util.List;

/**
 * Created by Leo on 03/10/2016.
 */
public class Forecast {
    private int id_forecast;
    private Location location;
    private CurrentDay currentDay;
    private Atmosphere atmosphere;
    private Wind wind;
    private List<ExtendedForecast> ExtendedForecast;// = new LinkedList<ExtendedForecast>();

    private Forecast(int id, Location location, CurrentDay currentDay, Atmosphere atmosphere, Wind wind, List<ExtendedForecast> extendedForecast) {
        this.location = location;
        this.currentDay = currentDay;
        this.atmosphere = atmosphere;
        this.wind = wind;
        this.id_forecast = id;
        ExtendedForecast = extendedForecast;
    }

    public int getId_forecast() {
        return id_forecast;
    }

    public void setId_forecast(int id_forecast) {
        this.id_forecast = id_forecast;
    }

    public Location getLocation() {
        return location;
    }

    public CurrentDay getCurrentDay() {
        return currentDay;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public Wind getWind() {
        return wind;
    }

    public List<com.weather.rest.Domain.ExtendedForecast> getExtendedForecast() {
        return ExtendedForecast;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id_forecast +
                "location=" + location +
                ", currentDay=" + currentDay +
                ", atmosphere=" + atmosphere +
                ", wind=" + wind +
                ", ExtendedForecast=" + ExtendedForecast +
                '}';
    }

    public static class ForecastBuilder {
        private int idb;
        private Location.LocationBuilder locb;
        private Location location;
        private CurrentDay.CurrentDayBuilder cdb;
        private CurrentDay currentDay;
        private Atmosphere atmosphere;
        private Wind wind;
        private List<ExtendedForecast> extendedForecast;

        public ForecastBuilder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public ForecastBuilder withCurrentDay(CurrentDay currentDay) {
            this.currentDay = currentDay;
            return this;
        }

        public ForecastBuilder withAtmosphere(Atmosphere atmosphere) {
            this.atmosphere = atmosphere;
            return this;
        }

        public ForecastBuilder withWind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public ForecastBuilder withExtendedForecast(List<ExtendedForecast> extendedForecast) {
            this.extendedForecast = extendedForecast;
            return this;
        }

        public Forecast createForecast() {
            return new Forecast(idb, location, currentDay, atmosphere, wind, extendedForecast);
        }

        public Forecast createDefaultForecast() {
            return new Forecast(idb, locb.createDefaultLocation(), cdb.createDefaultCurrentDay(), atmosphere, wind, extendedForecast);
        }
    }
}
