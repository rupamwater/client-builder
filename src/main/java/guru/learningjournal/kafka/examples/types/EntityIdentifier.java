
package guru.learningjournal.kafka.examples.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entity_id",
    "identifiers"
})
public class EntityIdentifier {

    @JsonProperty("entity_id")
    private String entity_id;
    @JsonProperty("identifiers")
    private Map<String, String>  identifiers;

    @JsonProperty("entity_id")
    public String getEntityId() {
        return entity_id;
    }

    @JsonProperty("entity_id")
    public void setEntityId(String entity_id) {
        this.entity_id = entity_id;
    }

    @JsonProperty("identifiers")
    public Map<String, String> getIdentifiers() {
        return this.identifiers;
    }

    @JsonProperty("identifiers")
    public void setIdentifiers(Map<String , String> identifiers) {
        this.identifiers = identifiers;
    }

    public EntityIdentifier addIdentifiers(String key, String value) {
        Map< String, String > identifiers = this.identifiers;
        identifiers.put(key, value);
        this.identifiers = identifiers;
        return this;
    }
    public EntityIdentifier withIdentifiers(Map<String, String> identifiers) {
        this.identifiers = identifiers;
        return this;
    }
    public EntityIdentifier withEntityId(String entity_id) {
        this.entity_id = entity_id;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("entity_id", entity_id).append("identifiers", identifiers).toString();
    }

}
