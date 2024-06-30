package be.kdg.mentoring.week04.f1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Circuit extends F1Entity {
    private String circuitId;
    private String circuitName;
    private Location location;
    private String url;

    public String getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(String circuitId) {
        this.circuitId = circuitId;
        setId(circuitId);
    }

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    @JsonProperty("Location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
