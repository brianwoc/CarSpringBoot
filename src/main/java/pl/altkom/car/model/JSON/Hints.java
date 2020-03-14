
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
    "visited_nodes.average",
    "visited_nodes.sum"
})
public class Hints {

    @JsonProperty("visited_nodes.average")
    private String visitedNodesAverage;
    @JsonProperty("visited_nodes.sum")
    private String visitedNodesSum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("visited_nodes.average")
    public String getVisitedNodesAverage() {
        return visitedNodesAverage;
    }

    @JsonProperty("visited_nodes.average")
    public void setVisitedNodesAverage(String visitedNodesAverage) {
        this.visitedNodesAverage = visitedNodesAverage;
    }

    @JsonProperty("visited_nodes.sum")
    public String getVisitedNodesSum() {
        return visitedNodesSum;
    }

    @JsonProperty("visited_nodes.sum")
    public void setVisitedNodesSum(String visitedNodesSum) {
        this.visitedNodesSum = visitedNodesSum;
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
