package ui;

import entities.Event;
import utils.EventGenerator;

import java.util.Arrays;

public class Wohui_He {
    public static void main(String[] args) {
        Event [] events = new Event[10];
        for (int i = 0; i < events.length; i++) {
            events[i] = EventGenerator.generateEvent();
        }
        Arrays.sort(events);
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
