package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Vasiliy Petrov";
        byte two = 2;
        short three = 3;
        int four = 4;
        long five = 5;
        float six = 6;
        double seven = 7;
        boolean eight = true;
        char nine = 'q';


        LOG.debug("User info name : {}, two : {}, three : {}, four : {}, five : {}, six : {}, seven : {}, eight : {}, nine : {}"
                , name, two, three, four, five, six, seven, eight, nine);
    }
}