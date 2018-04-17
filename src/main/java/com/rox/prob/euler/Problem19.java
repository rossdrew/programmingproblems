package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 *
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */
public class Problem19 implements NumericalProblem<Long> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Long solution() {
        try {
            return solution(dateFormat.parse("1901-01-01"), dateFormat.parse("2000-12-31"));
        }catch (ParseException ex){
            System.out.println("ERROR: Date ranges not parsable!");
        }

        return -1l;
    }

    public Long solution(Date from, Date to){
        System.out.print("Sundays on the first of the month from " + dateFormat.format(from) + " to " + dateFormat.format(to) + ": ");

        Long sundayCount = 0L;

        final Calendar startDate = calendarOf(from);
        final Calendar analysisDate = calendarOf(from);
        final Calendar endDate = calendarOf(to);

        for (int year = startDate.get(Calendar.YEAR); year <= endDate.get(Calendar.YEAR); year++){
            for (int month = 0; month < 12; month++, analysisDate.add(Calendar.MONTH, 1)){
                if (analysisDate.get(Calendar.DAY_OF_MONTH) != 1)
                    throw new RuntimeException("Expected month increment to land on the 1st, was " + analysisDate.get(Calendar.DAY_OF_MONTH) + " for " + dateFormat.format(analysisDate.getTime()));

                if (analysisDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                    ++sundayCount;
            }
        }

        return sundayCount;
    }

    private Calendar calendarOf(Date date){
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
