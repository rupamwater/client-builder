
package guru.learningjournal.kafka.examples.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "single_unique_party_id",
    "system_id",
    "source_system"
})
public class SystemIdentifier {

    @JsonProperty("single_unique_party_id")
    private String single_unique_party_id;
    @JsonProperty("system_id")
    private String system_id;
    @JsonProperty("source_system")
    private String source_system;

    @JsonProperty("single_unique_party_id")
    public String getSingleUniquePartyId() {
        return single_unique_party_id;
    }

    @JsonProperty("single_unique_party_id")
    public void setSingleUniquePartyId(String single_unique_party_id) {
        this.single_unique_party_id = single_unique_party_id;
    }

    @JsonProperty("system_id")
    public String getSystemId() {
        return system_id;
    }

    @JsonProperty("system_id")
    public void setSystemId(String system_id) {
        this.system_id = system_id;
    }

    @JsonProperty("source_system")
    public String getSourceSystem() {
        return source_system;
    }

    @JsonProperty("source_system")
    public void setSourceSystem(String source_system) {
        this.source_system = source_system;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("single_unique_party_id", single_unique_party_id).append("system_id", system_id).append("source_system", source_system).toString();
    }

}
