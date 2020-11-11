
package pl.morg.pracadomowatydzien5.model;

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
    "request_hash",
    "request_cached",
    "request_cache_expiry",
    "pictures"
})
public class Animes {

    @JsonProperty("request_hash")
    private String requestHash;
    @JsonProperty("request_cached")
    private Boolean requestCached;
    @JsonProperty("request_cache_expiry")
    private Integer requestCacheExpiry;
    @JsonProperty("pictures")
    private List<Picture> pictures = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("request_hash")
    public String getRequestHash() {
        return requestHash;
    }

    @JsonProperty("request_hash")
    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    @JsonProperty("request_cached")
    public Boolean getRequestCached() {
        return requestCached;
    }

    @JsonProperty("request_cached")
    public void setRequestCached(Boolean requestCached) {
        this.requestCached = requestCached;
    }

    @JsonProperty("request_cache_expiry")
    public Integer getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    @JsonProperty("request_cache_expiry")
    public void setRequestCacheExpiry(Integer requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    @JsonProperty("pictures")
    public List<Picture> getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
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
