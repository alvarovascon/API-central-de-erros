package com.central.main.suite;

import org.junit.Ignore;

@Ignore
public class AbstractTest {

    public AbstractTest() {
    }

    public static class UserIds {
        public static Long ONE = 1L;
        public static Long TWO = 2L;
        public static Long THREE = 3L;
        public static Long FOUR = 4L;
        public static Long FIVE = 5L;

        public UserIds() {
        }
    }

    public static class UserEmails {
        public static String EMAIL_ONE = "admin@admin.com";
        public static String EMAIL_TWO = "alvaro@gmail.com";
        public static String EMAIL_THREE = "israel@gmail.com";
        public static String EMAIL_FOUR = "leticia@gmail.com";
        public static String EMAIL_FIVE = "rodolfo@gmail.com";

        public UserEmails() {
        }
    }

    public static class EventIds {
        public static Long ONE = 1L;
        public static Long TWO = 2L;
        public static Long THREE = 3L;

        public EventIds() {
        }
    }
}
