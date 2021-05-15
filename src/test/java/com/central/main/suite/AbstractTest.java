package com.central.main.suite;

import org.junit.Ignore;

import java.sql.Timestamp;

@Ignore
public class AbstractTest {

    public AbstractTest() {
    }

    public static class UserIds {
        public static Long ONE = 1L;

        public UserIds() {
        }
    }

    public static class UserEmails {
        public static String EMAIL_ONE = "admin@admin.com";

        public UserEmails() {
        }
    }

    public static class EventIds {
        public static Long ONE = 1L;

        public EventIds() {
        }
    }

    public static class EventLevels {
        public static String WARNING = "warning";

    }

    public static class EventLogs {
        public static String LOG = "log";

    }

    public static class EventOrigins {
        public static String ORIGIN = "origin";

    }

    public static class EventDates {
        static String text = "2011-10-02 18:48:05";
        static Timestamp ts = Timestamp.valueOf(text);
        public static Timestamp DATE = ts;
    }
}
