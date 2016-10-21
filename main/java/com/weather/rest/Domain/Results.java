package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results
{
    private Channel channel;

    public Results(Channel channel)
    {
        this.channel = channel;
    }

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+"]";
    }

@Component
    public static class ResultsBuilder {
        private Channel channel;

        public ResultsBuilder withChannel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public static ResultsBuilder aResults()
        {return new ResultsBuilder();}

        public Results createResults() {
            return new Results(channel);
        }
    }
}