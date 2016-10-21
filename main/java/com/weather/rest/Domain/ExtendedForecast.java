package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 03/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedForecast
{
    private CurrentDay day;

    private ExtendedForecast(CurrentDay day) {
        this.day = day;
    }

    public ExtendedForecast() {
    }

    public CurrentDay getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "ExtendedForecast{" +
                "day=" + day +
                '}';
    }
@Component
    public static class ExtendedForecastBuilder
    {
        private CurrentDay.CurrentDayBuilder defaultDay;
        private CurrentDay day;

        public ExtendedForecastBuilder withDay(CurrentDay day) {
            this.day = day;
            return this;
        }

        public ExtendedForecast createExtendedForecast() {
            return new ExtendedForecast(day);
        }

        public ExtendedForecast createDefaultExtendedForecast() {
            return new ExtendedForecast(defaultDay.createDefaultCurrentDay());
        }
    }
}
