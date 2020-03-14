
package pl.altkom.car.model.JSON;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distance",
    "weight",
    "time",
    "transfers",
    "snapped_waypoints"
})
public class Path {

    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("transfers")
    private Integer transfers;
    @JsonProperty("snapped_waypoints")
    private String snappedWaypoints;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("transfers")
    public Integer getTransfers() {
        return transfers;
    }

    @JsonProperty("transfers")
    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    @JsonProperty("snapped_waypoints")
    public String getSnappedWaypoints() {
        return snappedWaypoints;
    }

    @JsonProperty("snapped_waypoints")
    public void setSnappedWaypoints(String snappedWaypoints) {
        this.snappedWaypoints = snappedWaypoints;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
