package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Astronomy
{
    private String sunset;
    private String sunrise;

    private Astronomy(String sunset, String sunrise) {
        this.sunset = sunset;
        this.sunrise = sunrise;
    }

    public String getSunset ()
    {
        return sunset;
    }

    public void setSunset (String sunset)
    {
        this.sunset = sunset;
    }

    public String getSunrise ()
    {
        return sunrise;
    }

    public void setSunrise (String sunrise)
    {
        this.sunrise = sunrise;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sunset = "+sunset+", sunrise = "+sunrise+"]";
    }

    @Component
    public static class AstronomyBuilder
    {
        private String sunset;
        private String sunrise;

        public AstronomyBuilder withSunset(String sunset) {
            this.sunset = sunset;
            return this;
        }

        public AstronomyBuilder withSunrise(String sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public static AstronomyBuilder aAstronomy()
        {return new AstronomyBuilder();}

        public Astronomy createAstronomy() {
            return new Astronomy(sunset, sunrise);
        }
    }
}