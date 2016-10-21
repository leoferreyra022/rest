package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item
{
    private Guid guid;
    private String pubDate;
    private String title;
    private List<Forecast> forecast = new LinkedList<>();
    private Condition condition;
    private String description;
    private String link;
    private String longa;
    private String lat;

    public Item(Guid guid, String pubDate, String title
                , List<Forecast> forecast, Condition condition,
                String description, String link, String longs, String lat) {
        this.guid = guid;
        this.pubDate = pubDate;
        this.title = title;
        this.forecast = forecast;
        this.condition = condition;
        this.description = description;
        this.link = link;
        this.longa = longs;
        this.lat = lat;
    }

    public Guid getGuid ()
    {
        return guid;
    }

    public void setGuid (Guid guid)
    {
        this.guid = guid;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public List<Forecast> getForecast ()
    {
        return forecast;
    }

    public void setForecast (List<Forecast> forecast)
    {
        this.forecast = forecast;
    }

    public Condition getCondition ()
    {
        return condition;
    }

    public void setCondition (Condition condition)
    {
        this.condition = condition;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLong ()
    {
        return longa;
    }

    public void setLong (String longs)
    {
        this.longa = longs;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [guid = "+guid+", pubDate = "+pubDate+", title = "+title+", forecast = "
                +forecast+", condition = "+condition+", description = "+description+", link = "
                +link+", long = "+longa+", lat = "+lat+"]";
    }
@Component
    public static class ItemBuilder
    {
        private Guid guid;
        private String pubDate;
        private String title;
        private List<Forecast> forecast = new LinkedList<>();
        private Condition condition;
        private String description;
        private String link;
        private String longs;
        private String lat;

        public ItemBuilder withGuid(Guid guid) {
            this.guid = guid;
            return this;
        }

        public ItemBuilder withPubDate(String pubDate) {
            this.pubDate = pubDate;
            return this;
        }

        public ItemBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ItemBuilder withForecast(List forecast) {
            this.forecast = forecast;
            return this;
        }

        public ItemBuilder withCondition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withLink(String link) {
            this.link = link;
            return this;
        }

        public ItemBuilder withLongs(String longs) {
            this.longs = longs;
            return this;
        }

        public ItemBuilder withLat(String lat) {
            this.lat = lat;
            return this;
        }

        public static ItemBuilder aItem()
        {return new ItemBuilder();}

        public Item createItem() {
            return new Item(guid, pubDate, title, forecast, condition, description, link, longs, lat);
        }
    }
}