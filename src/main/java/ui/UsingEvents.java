package ui;

import entities.Event;
import utils.EventGenerator;

public class UsingEvents {
    public static void main(String[] args) {
        System.out.println("Create an array of 10 random events and display it:");
        Event [] events = new Event[10];
        for (int i = 0; i < events.length; i++) {
            events[i] = EventGenerator.generateEvent();
        }

        for (Event event : events) {
            System.out.println(event);
        }
    }
}
