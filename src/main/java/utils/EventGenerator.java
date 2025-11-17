package utils;

import entities.Event;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class EventGenerator {
    public final static String [] VALID_SOURCES = {"HEAT", "TEMP", "PLUG", "MOTION", "CAMERA"};
    private static String getRandomSource(){
        Random random = new Random();
        int sourcePos = random.nextInt(VALID_SOURCES.length);
        return VALID_SOURCES[sourcePos];
    }

    private static LocalDateTime getRandomTimeStamp(){
        Random random = new Random();

        // Generate month and year
        int mon = random.nextInt(1, 12);
        int year = random.nextInt(2020, LocalDate.now().getYear()+1);

        // Find out how many days are in that month
        LocalDate firstOfMonth = LocalDate.of(year, mon, 1);
        int lenOfMonth = firstOfMonth.lengthOfMonth();
        int day = random.nextInt(1, lenOfMonth+1);

        // Generate time of day
        int hour = random.nextInt(0, 23);
        int min = random.nextInt(0, 59);

        // Create overall timestamp
        return LocalDateTime.of(year, mon, day, hour, min);
    }

    public static Event generateEvent(){
        LocalDateTime timestamp = getRandomTimeStamp();
        UUID id = UUIDGenerator.generateType1UUID(timestamp);
        String source = getRandomSource();
        // Use external library (!) to generate random text
        String desc = RandomStringUtils.randomAlphanumeric(10) + " from " + source;

        return new Event(id, timestamp, source, desc);
    }
}
