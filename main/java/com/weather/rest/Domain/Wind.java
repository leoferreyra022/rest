package com.weather.rest.Domain;

/**
 * Created by Leo on 03/10/2016.
 */
public class Wind {
    private int velocity;
    private char direction;

    private Wind(int velocity, char direction) {

        this.velocity = velocity;
        this.direction = direction;
    }

    public int getVelocity() {
        return velocity;
    }

    public char getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "velocity=" + velocity +
                ", direction=" + direction +
                '}';
    }

    public static class WindBuilder {
        private int velocity;
        private char direction;

        public WindBuilder withVelocity(int velocity) {
            this.velocity = velocity;
            return this;
        }

        public WindBuilder withDirection(char direction) {
            this.direction = direction;
            return this;
        }

        public Wind createWind() {
            return new Wind(velocity, direction);
        }

        public Wind createDefaultWind() {
            return new Wind(20, 'N');
        }
    }
}
