package entities;
import java.util.ArrayList;
import java.util.List;
public class method {
    public Event[] getEventsForSource(Event events[], String source) {
        if (events == null || source == null) {
        return new Event[0];
        }
        List<Event> matches = new ArrayList<>();
        for (Event event : events) {
        if (event != null && source.equals(event.getSource())) {
        matches.add(event);
        }
        }
        return matches.toArray(new Event[0]);
    }
}
