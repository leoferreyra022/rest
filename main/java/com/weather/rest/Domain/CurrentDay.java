package com.weather.rest.Domain;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Leo on 03/10/2016.
 */
public class CurrentDay
{
    private Date date;
    private int today;// = Calendar.getInstance().DAY_OF_WEEK;
    private String description;
    private int maxTemp;
    private int minTemp;

    public CurrentDay()
    {

    }

    private CurrentDay(Date date, int today, String description, int maxTemp, int minTemp) {
        this.date = date;
        this.today = Calendar.getInstance().DAY_OF_WEEK;
        this.description = description;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public int getToday() {
        return today;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "CurrentDay{" +
                "day=" + today +
                ", date=" + date +
                ", min temp=" + minTemp +
                ", max temp=" + maxTemp +
                ", description='" + description + '\'' +
                '}';
    }

    public static class CurrentDayBuilder {
        private Date date;
        private int dayOfWeek;
        private String description;
        private int maxTemp;
        private int minTemp;

        public CurrentDayBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public CurrentDayBuilder withToday(int today) {
            this.dayOfWeek = today;
            return this;
        }

        public CurrentDayBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CurrentDayBuilder withMaxtemp(int maxTemp) {
            this.maxTemp = maxTemp;
            return this;
        }

        public CurrentDayBuilder withMintemp(int minTemp) {
            this.minTemp = minTemp;
            return this;
        }

        public CurrentDay createCurrentDay() {
            return new CurrentDay(date, dayOfWeek, description, maxTemp, minTemp);
        }

        public CurrentDay createDefaultCurrentDay() {
            return new CurrentDay(new Date(),Calendar.getInstance().DAY_OF_WEEK, "Dia soleado", 12, 24);
        }
    }
}
