
package guru.learningjournal.kafka.examples.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entity_id",
    "organization_type",
    "organization_name",
    "registration_number",
    "registration_country",
    "registration_country_code",
    "active_status",
    "locking_status",
    "identifiers"
})

public class Corporate {

    @JsonProperty("entity_id")
    private String entity_id;
    @JsonProperty("organization_type")
    private String organization_type;
    @JsonProperty("organization_name")
    private String organization_name;
    @JsonProperty("registration_number")
    private String registration_number;
    @JsonProperty("registration_country")
    private String registration_country;
    @JsonProperty("registration_country_code")
    private String registration_country_code;
    @JsonProperty("active_status")
    private String active_status;
    @JsonProperty("locking_status")
    private String locking_status;
    @JsonProperty("identifiers")
    private Map<String , String> identifiers;
    @JsonProperty("entity_id")
    public String getEntityId() {
        return entity_id;
    }

    @JsonProperty("entity_id")
    public void setEntityId(String entity_id) {
        this.entity_id = entity_id;
    }

    @JsonProperty("organization_type")
    public String getOrganizationType() {
        return organization_type;
    }

    @JsonProperty("organization_type")
    public void setOrganizationType(String organization_type) {
        this.organization_type = organization_type;
    }

    @JsonProperty("organization_name")
    public String getOrganizationName() {
        return organization_name;
    }

    @JsonProperty("organization_name")
    public void setOrganizationName(String organization_name) {
        this.organization_name = organization_name;
    }

    @JsonProperty("registration_number")
    public String getRegistration_number() {
        return registration_number;
    }

    @JsonProperty("registration_number")
    public void setRegistrationNumber(String registration_number) {
        this.registration_number = registration_number;
    }

    @JsonProperty("registration_country")
    public String getRegistrationCountry() {
        return registration_country;
    }

    @JsonProperty("registration_country")
    public void setRegistrationCountry(String registration_country) {
        this.registration_country = registration_country;
    }
    @JsonProperty("registration_country_code")
    public String getRegistrationCountryCode() {
        return registration_country_code;
    }

    @JsonProperty("registration_country_code")
    public void setRegistrationCountryCode(String registration_country_code) {
        this.registration_country = registration_country;
    }
    @JsonProperty("active_status")
    public String getActiveStatus() {
        return active_status;
    }

    @JsonProperty("active_status")
    public void setActiveStatus(String active_status) {
        this.registration_country = registration_country;
    }
    @JsonProperty("locking_status")
    public String getLockingStatus() {
        return locking_status;
    }

    @JsonProperty("locking_status")
    public void setLockingStatus(String locking_status) {
        this.registration_country = registration_country;
    }
    @JsonProperty("identifiers")
    public Map<String, String> getIdentifiers() {
        return identifiers;
    }

    @JsonProperty("locking_status")
    public void setIdentifiers(Map<String, String> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("entity_id", entity_id).append("organization_type", organization_type).append("organization_name", organization_name)
                .append("registration_country", registration_country).append("registration_country_code", registration_country_code)
                .append("active_status", active_status).append("locking_status", locking_status).toString();
    }

}
