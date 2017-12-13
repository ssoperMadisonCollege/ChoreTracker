package edu.matc.controller;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;

import static edu.matc.controller.Quickstart.getCalendarService;

/**
 * Refer to the Java quickstart on how to setup the environment:
 * https://developers.google.com/google-apps/calendar/quickstart/java
 * Change the scope to CalendarScopes.CALENDAR and delete any stored
 * credentials.
 */
public class AddEvent {

    /**
     * The Service.
     */
    com.google.api.services.calendar.Calendar service = getCalendarService();

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Instantiates a new Add event.
     *
     * @throws IOException the io exception
     */
    public AddEvent() throws IOException {};

    /**
     * Add.
     *
     * @throws IOException the io exception
     */
    public void add() throws IOException {

        Event event = new Event()
                .setSummary("Google I/O 2015")
                .setDescription("A chance to hear more about Google's developer products.");

        DateTime startDateTime = new DateTime("2015-05-28T09:00:00-07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setStart(start);

        DateTime endDateTime = new DateTime("2015-05-28T17:00:00-07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setEnd(end);

        String[] recurrence = new String[]{"RRULE:FREQ=DAILY;COUNT=2"};
        event.setRecurrence(Arrays.asList(recurrence));

        EventAttendee[] attendees = new EventAttendee[]{
                new EventAttendee().setEmail("lpage@example.com"),
                new EventAttendee().setEmail("sbrin@example.com"),
        };
        event.setAttendees(Arrays.asList(attendees));

        EventReminder[] reminderOverrides = new EventReminder[]{
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).execute();

        log.info("Event created: %s\n" + event.getHtmlLink());

    }
}
