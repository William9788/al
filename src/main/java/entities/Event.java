package entities;

import utils.UUIDGenerator;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Event implements Comparable<Event>{
    public final static String [] VALID_SOURCES = {"HEAT", "TEMP", "PLUG", "MOTION", "CAMERA"};
    private final UUID id;
    private final LocalDateTime timestamp;
    private final String source;
    private final String description;

    public Event(UUID id, LocalDateTime timestamp, String source, String description) {
        validateSource(source);

        this.id = id;
        this.timestamp = timestamp;
        this.source = source;
        this.description = description;
    }

    public Event(String source, String description) {
        validateSource(source);
        this.timestamp = LocalDateTime.now();
        this.id = UUIDGenerator.generateType1UUID(timestamp);
        this.source = source;
        this.description = description;
    }

    @Override
    public int compareTo(Event o) {
        return this.timestamp.compareTo(o.timestamp);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public boolean isValidSource(String source){
        for (String validSource : VALID_SOURCES) {
            if(validSource.equals(source)){
                return true;
            }
        }
        return false;
    }

    private void validateSource(String source) {
        if(!isValidSource(source)){
            throw new IllegalArgumentException(
                    "Source " + source + " is not a valid Source option.");
        }
    }
}
