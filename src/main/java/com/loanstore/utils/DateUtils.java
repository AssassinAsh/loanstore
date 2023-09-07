package com.loanstore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public static Date getDateFromString(String date, String format) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(date);
        } catch (ParseException ex) {
            LOGGER.error("Error while parsing date: {}", ex.getMessage());
            throw new Exception("Date should be in format: " + format);
        }
    }
}
