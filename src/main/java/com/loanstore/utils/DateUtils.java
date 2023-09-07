package com.loanstore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public static Date getDateFromString(final String date, final String format) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(date);
        } catch (ParseException ex) {
            LOGGER.error("Error while parsing date: {}", ex.getMessage());
            throw new Exception("Date should be in format: " + format);
        }
    }

    public static Long getDateDifference(final Date d1, final Date d2) {
        long diff = Math.abs(d1.getTime() - d2.getTime());
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
