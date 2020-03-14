
package pl.altkom.car.model.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hints",
    "info",
    "paths"
})
public class Example {

    @JsonProperty("hints")
    private Hints hints;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("paths")
    private List<Path> paths = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hints")
    public Hints getHints() {
        return hints;
    }

    @JsonProperty("hints")
    public void setHints(Hints hints) {
        this.hints = hints;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("paths")
    public List<Path> getPaths() {
        return paths;
    }

    @JsonProperty("paths")
    public void setPaths(List<Path> paths) {
        this.paths = paths;
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
