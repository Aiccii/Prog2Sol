package be.kdg.mentoring.week04.f1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season extends F1Entity {
    @JsonProperty("season")
    private int year;
    private String url;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        setId(String.valueOf(year));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
