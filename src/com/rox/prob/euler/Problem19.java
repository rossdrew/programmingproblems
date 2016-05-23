package com.rox.prob.euler;

import com.rox.prob.NumericalProblem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 *You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */
public class Problem19 implements NumericalProblem<Long> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String[] MONTH = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private String[] DOW = {"ERROR","Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

    private int[] days_in_month = {31, 28, 31, 30, 30, 31, 31, 31, 30, 31, 30, 31};

    @Override
    public Long solution() {
        try {
            return solution(dateFormat.parse("1900-01-01"), dateFormat.parse("2000-12-31"));
        }catch (ParseException ex){
            System.out.println("ERROR: Date ranges not parsable!");
        }

        return -1l;
    }

    private boolean isLeapYear(int year){
        if (year % 100 == 0){
            return (year % 400 == 0) ? true : false;
        }else{
            return (year % 4 == 0) ? true : false;
        }
    }

    public Long solution(Date from, Date to){
        int startYear = from.getYear() + 1900;
        int dayIndex = 1;
        int endYear = 1902;//to.getYear() + 1900;

        int sundays = 0;

        for (int yearIndex = startYear; yearIndex < endYear; yearIndex++){
            System.out.println(yearIndex + " starting on a " + DOW[dayIndex]);
            days_in_month[1] = isLeapYear(yearIndex) ? 29 : 28;

            //January (Find all the Sundays)
            for (int dayOfMonth = 0; dayOfMonth < days_in_month[0]; dayOfMonth++) {
                if (dayIndex % 7 == 0) {
                    System.out.println(MONTH[0] + " " + (dayOfMonth + 1) + " " + yearIndex);
                    sundays++;
                    dayIndex = 0;
                }
                dayIndex++;
            }

            //Rest of year (get the last day of week of the year
            int daysInRestOfYear = 0;
            for (int i=1; i<days_in_month.length; i++){
                daysInRestOfYear += i;
            }
            //1901 starts on Tuesday, 1st January (Sundays in Jan = 6,13,20,27)
            int lastDayOfYear = (daysInRestOfYear + dayIndex) % 7;
            dayIndex = lastDayOfYear == 0 ? 1 : lastDayOfYear;

            /*DEBUG*/System.out.println("Last day of " + yearIndex + " = " + DOW[dayIndex]);
        }

        /*DEBUG*/System.out.println(sundays + " Sundays found...");
        return -1l;
    }
}
