package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guid
{
    private String isPermaLink;

    public Guid(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    public String getIsPermaLink ()
    {
        return isPermaLink;
    }

    public void setIsPermaLink (String isPermaLink)
    {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isPermaLink = "+isPermaLink+"]";
    }

    public static class GuidBuilder {
        private String isPermaLink;

        public GuidBuilder withIsPermaLink(String isPermaLink) {
            this.isPermaLink = isPermaLink;
            return this;
        }

        public static GuidBuilder aGuid()
        {return new GuidBuilder();}

        public Guid createGuid() {
            return new Guid(isPermaLink);
        }
    }
}