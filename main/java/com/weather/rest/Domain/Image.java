package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 20/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image
{
    private String title;
    private String height;
    private String link;
    private String width;
    private String url;

    public Image(String title, String height, String link, String width, String url) {
        this.title = title;
        this.height = height;
        this.link = link;
        this.width = width;
        this.url = url;
    }

    public String getTitle ()
    {
        return title;
    }
    public void setTitle (String title)
    {
        this.title = title;
    }
    public String getHeight ()
    {
        return height;
    }
    public void setHeight (String height)
    {
        this.height = height;
    }
    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", height = "+height+", link = "+link+", width = "+width
                +", url = "+url+"]";
    }
@Component
    public static class ImageBuilder
{
        private String title;
        private String height;
        private String link;
        private String width;
        private String url;

        public ImageBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ImageBuilder withHeight(String height) {
            this.height = height;
            return this;
        }

        public ImageBuilder withLink(String link) {
            this.link = link;
            return this;
        }

        public ImageBuilder withWidth(String width) {
            this.width = width;
            return this;
        }

        public ImageBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public static ImageBuilder aImage()
        {return new ImageBuilder();}

        public Image createImage() {
            return new Image(title, height, link, width, url);
        }
    }
}
