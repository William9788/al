package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

public class UUIDGenerator {
    private static long get64LeastSignificantBits() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }

    private static long get64MostSignificantBits(long currentTimeMillis) {
        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12;
        final long time_hi = ((currentTimeMillis >> 48) & 0x0FFF);
        return time_low | time_mid | version | time_hi;
    }

    public static UUID generateType1UUID(LocalDateTime timestamp) {
        ZonedDateTime zdt = timestamp.atZone(ZoneId.systemDefault());
        long timestampMilli = zdt.toInstant().toEpochMilli();
        long most64SigBits = get64MostSignificantBits(timestampMilli);
        long least64SigBits = get64LeastSignificantBits();
        return new UUID(most64SigBits, least64SigBits);
    }
}
