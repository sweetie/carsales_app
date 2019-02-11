package com.carsales.project.mvp.common.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Enny Querales
 */

public class Date {

    /**
     * Attributes
     */
    private int year;
    private int month;
    private int day;
    private Calendar calendar;


    public Date() {
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
    }

    public Date(int year, int month, int day) {
        calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        String monthString = "";
        switch (month) {
            case 0:
                monthString = "Jan";
                break;
            case 1:
                monthString = "Feb";
                break;
            case 2:
                monthString = "Mar";
                break;
            case 3:
                monthString = "Apr";
                break;
            case 4:
                monthString = "May";
                break;
            case 5:
                monthString = "Jun";
                break;
            case 6:
                monthString = "Jul";
                break;
            case 7:
                monthString = "Aug";
                break;
            case 8:
                monthString = "Sep";
                break;
            case 9:
                monthString = "Oct";
                break;
            case 10:
                monthString = "Nov";
                break;
            case 11:
                monthString = "Dec";
                break;
        }
        return day + " " + monthString + ", " + year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @SuppressWarnings("RedundantIfStatement")
    public boolean isValid() {
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        if (year > currentYear)
            return true;
        else if (year == currentYear) {
            if (month > currentMonth)
                return true;
            else if (month == currentMonth) {
                if (day >= currentDay)
                    return true;
                else
                    return false;
            }
        }

        return false;
    }

    public boolean isGreaterThan(Date date) {
        if (this.year == date.year) {
            if (this.month > date.month)
                return true;
            else if (this.month == date.month) {
                return this.day > date.day;
            }
        }
        return false;
    }

    public static String getDateToConvert() {
        java.util.Date today = new java.util.Date();

        //If you print Date, you will get un formatted output
        System.out.println("Today is : " + today);

        //formatting date in Java using SimpleDateFormat
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        String date = DATE_FORMAT.format(today);
        System.out.println("Today in yyyyMMdd format : " + date);
        System.out.println("Today in yyyyMMdd format : " + md5(date));
        return md5(date);
        //return md5("20181026");

    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}


