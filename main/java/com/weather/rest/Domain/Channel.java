package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 20/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel
{
    private Wind wind;
    private Location location;
    private String link;
    private Atmosphere atmosphere;
    private Image image;
    private String ttl;
    private Astronomy astronomy;
    private Units units;
    private String title;
    private String description;
    private Item item;
    private String lastBuildDate;
    private String language;

    private Channel(Wind wind, Location location, String link, Atmosphere atmosphere
            , Image image, String ttl, Astronomy astronomy, Units units, String title,
                   String description, Item item, String lastBuildDate, String language)
    {
        this.wind = wind;
        this.location = location;
        this.link = link;
        this.atmosphere = atmosphere;
        this.image = image;
        this.ttl = ttl;
        this.astronomy = astronomy;
        this.units = units;
        this.title = title;
        this.description = description;
        this.item = item;
        this.lastBuildDate = lastBuildDate;
        this.language = language;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public Atmosphere getAtmosphere ()
    {
        return atmosphere;
    }

    public void setAtmosphere (Atmosphere atmosphere)
    {
        this.atmosphere = atmosphere;
    }

    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    public String getTtl ()
    {
        return ttl;
    }

    public void setTtl (String ttl)
    {
        this.ttl = ttl;
    }

    public Astronomy getAstronomy ()
    {
        return astronomy;
    }

    public void setAstronomy (Astronomy astronomy)
    {
        this.astronomy = astronomy;
    }

    public Units getUnits ()
    {
        return units;
    }

    public void setUnits (Units units)
    {
        this.units = units;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Item getItem ()
    {
        return item;
    }

    public void setItem (Item item)
    {
        this.item = item;
    }

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [wind = "+wind+", location = "+location+", link = "+link+", atmosphere = "+atmosphere+", image = "+image+", ttl = "+ttl+", astronomy = "+astronomy+", units = "+units+", title = "+title+", description = "+description+", item = "+item+", lastBuildDate = "+lastBuildDate+", language = "+language+"]";
    }
    @Component
    public static class ChannelBuilder {
        private Wind wind;
        private Location location;
        private String link;
        private Atmosphere atmosphere;
        private Image image;
        private String ttl;
        private Astronomy astronomy;
        private Units units;
        private String title;
        private String description;
        private Item item;
        private String lastBuildDate;
        private String language;

        public ChannelBuilder setWind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public ChannelBuilder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public ChannelBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        public ChannelBuilder setAtmosphere(Atmosphere atmosphere) {
            this.atmosphere = atmosphere;
            return this;
        }

        public ChannelBuilder setImage(Image image) {
            this.image = image;
            return this;
        }

        public ChannelBuilder setTtl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public ChannelBuilder setAstronomy(Astronomy astronomy) {
            this.astronomy = astronomy;
            return this;
        }

        public ChannelBuilder setUnits(Units units) {
            this.units = units;
            return this;
        }

        public ChannelBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ChannelBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ChannelBuilder setItem(Item item) {
            this.item = item;
            return this;
        }

        public ChannelBuilder setLastBuildDate(String lastBuildDate) {
            this.lastBuildDate = lastBuildDate;
            return this;
        }

        public static ChannelBuilder aChannel()
        {return new ChannelBuilder();}

        public ChannelBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Channel createChannel() {
            return new Channel(wind, location, link, atmosphere, image, ttl, astronomy, units, title, description, item, lastBuildDate, language);
        }
    }
}