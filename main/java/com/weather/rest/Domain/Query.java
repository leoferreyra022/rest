package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Query
{
    private Results results;
    private String count;
    private String created;
    private String lang;

    public Query(Results results, String count, String created, String lang) {
        this.results = results;
        this.count = count;
        this.created = created;
        this.lang = lang;
    }

    public Results getResults ()
    {
        return results;
    }

    public void setResults (Results results)
    {
        this.results = results;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", count = "+count+", created = "+created+", lang = "+lang+"]";
    }
@Component
    public static class QueryBuilder {
        private Results results;
        private String count;
        private String created;
        private String lang;

        public QueryBuilder withResults(Results results) {
            this.results = results;
            return this;
        }

        public QueryBuilder withCount(String count) {
            this.count = count;
            return this;
        }

        public QueryBuilder withCreated(String created) {
            this.created = created;
            return this;
        }

        public QueryBuilder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public static QueryBuilder aQuery()
        {return new QueryBuilder();}

        public Query createQuery() {
            return new Query(results, count, created, lang);
        }
    }
}