package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 03/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind
{
    private int idWind;
    private int velocity;
    private String direction;

    private Wind(int velocity, String direction)
    {
        this.velocity = velocity;
        this.direction = direction;
    }

    public int getIdWind() {
        return idWind;
    }

    public void setIdWind(int idWind) {
        this.idWind = idWind;
    }

    public int getVelocity() {
        return velocity;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "velocity=" + velocity +
                ", direction=" + direction +
                '}';
    }
    @Component
    public static class WindBuilder
    {
        private int velocity;
        private String direction;

        public WindBuilder withVelocity(int velocity) {
            this.velocity = velocity;
            return this;
        }

        public WindBuilder withDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public static WindBuilder aWind()
        {return new WindBuilder();}

        public Wind createWind() {
            return new Wind(velocity, direction);
        }

        public Wind createDefaultWind() {
            return new Wind(20, "N");
        }
    }
}
