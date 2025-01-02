package ethos.runehub.event.holiday;

import ethos.runehub.TimeUtils;
import ethos.runehub.event.FixedScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EndChristmasFixedScheduleEvent extends FixedScheduleEvent {

    // Event start date and time UTC dec 1st
    public static final ZonedDateTime START_EVENT = ZonedDateTime.now(ZoneId.of("UTC")).withMonth(12).withDayOfMonth(31).withHour(0).withMinute(0).withSecond(0);

    // Duration between now and the start of the event
    public static final Duration DURATION_BETWEEN_NOW_AND_START = TimeUtils.getDurationBetween(ZonedDateTime.now(ZoneId.of("UTC")), START_EVENT);

    // Check if DURATION_BETWEEN_FIRST_UNTIL_CHRISTMAS is less than 0 and if it returns 0
    public static final Duration DURATION_UNTIL_EVENT_START = DURATION_BETWEEN_NOW_AND_START.isNegative() ?
            TimeUtils.getDurationBetween(ZonedDateTime.now(ZoneId.of("UTC")), ZonedDateTime.now(ZoneId.of("UTC")).withMonth(12).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withYear(START_EVENT.getYear() + 1))
            : DURATION_BETWEEN_NOW_AND_START;

    private static final Logger logger = LoggerFactory.getLogger(EndChristmasFixedScheduleEvent.class);

    @Override
    public void execute() {
        logger.info("Christmas event has ended!");
    }

    @Override
    protected void onInitialize() {
        // Check if it's currently within the event start and end date and execute the event if it is
        if (ZonedDateTime.now(ZoneId.of("UTC")).isAfter(START_EVENT)) {
            execute();
        }
        logger.debug("Christmas Event clean-up begins in: {} hours.", DURATION_UNTIL_EVENT_START.toHours());
    }

    public EndChristmasFixedScheduleEvent() {
        super(DURATION_UNTIL_EVENT_START.toMillis(), "Christmas");
    }
}
