package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DictionaryOut {

    private int id;
    @JsonProperty("isEnabled")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Boolean isEnabled;
    private String name;
    private String createdDate;
    private String updatedDate;

    public int getId() {
        return id;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public String getName() {
        return name;
    }

    public String getNameLowerCase() {
        return name.toLowerCase();
    }

    public OffsetDateTime getCreatedDate() {
        LocalDateTime createdUtcDate = LocalDateTime.parse(createdDate.substring(0, 19));
        OffsetDateTime createdUtcDateWithZone = createdUtcDate.atOffset(ZoneOffset.UTC);
        return createdUtcDateWithZone;
    }

    public OffsetDateTime getUpdatedDate() {
        LocalDateTime updatedUtcDate = LocalDateTime.parse(updatedDate.substring(0, 19));
        OffsetDateTime updatedUtcDateWithZone = updatedUtcDate.atOffset(ZoneOffset.UTC);
        return updatedUtcDateWithZone;
    }
}
