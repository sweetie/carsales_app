package com.carsales.project.mvp.common.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateTools {

    /**
     * getDateFormat() Devuelve un String de una fecha (Date)<br><br>
     * Los valores del parametro format pueden ser:<br>
     * 'S' para formato corto de hora <br>
     * 'M' para formato medio de hora <br>
     * 'L' para formato largo de hora <br>
     *
     * @param date   Date
     * @param format char
     * @return String
     */
    public static String getDateFormat(Date date, char format) {
        String fmt = "";
        if (date == null) {
            fmt = "null";
        } else {
            switch (format) {
                case 'M':
                    fmt = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);//DD/MM/YYYY
                    break;
                case 'L':
                    fmt = DateFormat.getDateInstance(DateFormat.LONG).format(date);//8 de enero de 2007
                    break;
                case 'S':
                    fmt = DateFormat.getDateInstance(DateFormat.SHORT).format(date);//DD/MM/YY
                    break;
            }
        }
        return fmt;
    }

    public static String getDateFormatCurrent(Date date) {
        String fmt = "";
        char format = '-';
        try {
            DateFormat formatter = new SimpleDateFormat();
            if (date == null) {
                fmt = "null";
            } else {
                //format = Application.getInstance().getGlobalSettings().getFormatDate().charAt(0);
                format = 'M';
                switch (format) {
                    case 'M':
                        fmt = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);//DD/MM/YYYY
                        break;
                    case 'L':
                        fmt = DateFormat.getDateInstance(DateFormat.LONG).format(date);//8 de enero de 2007
                        break;
                    case 'S':
                        fmt = DateFormat.getDateInstance(DateFormat.SHORT).format(date);//DD/MM/YY
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fmt;
    }

    /**
     * getTimeFormat() Devuelve un String de una hora (Date)<br><br>
     * Los valores del parametro format pueden ser:<br>
     * 'S' para formato corto de hora <br>
     * 'M' para formato medio de hora <br>
     * 'L' para formato largo de hora <br>
     *
     * @param time   Date
     * @param format char
     * @return String
     */
    public static String getTimeFormat(Date time, char format) {
        String fmt = "";
        if (time == null) {
            fmt = "null";
        } else {
            switch (format) {
                case 'M':
                    fmt = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(time);
                    break;
                case 'L':
                    fmt = DateFormat.getTimeInstance(DateFormat.LONG).format(time);
                    break;
                case 'S':
                    fmt = DateFormat.getTimeInstance(DateFormat.SHORT).format(time);
                    break;
            }
        }
        return fmt;
    }

    /**
     * isBefore devuelve true si el parametro d1 es menor en tiempo que d2 y
     * false si no lo es
     * <br>
     * <br>Nota: Si son iguales devuelve true
     *
     * @param d1 Date
     * @param d2 Date
     * @return boolean
     */
    public static boolean isBefore(Date d1, Date d2) {
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();

        now.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE),
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        g1.clear(Calendar.MILLISECOND);
        g2.clear(Calendar.MILLISECOND);
        return g1.before(g2);
    }

    public static boolean isAfter(Date d1, Date d2) {
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();

        now.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE),
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        g1.clear(Calendar.MILLISECOND);
        g2.clear(Calendar.MILLISECOND);
        return g1.after(g2);
    }

    public static boolean isEquals(Date d1, Date d2) {
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        now.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));/*,
         now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
         now.get(Calendar.SECOND));*/

        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));/*,
         cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
         cal.get(Calendar.SECOND));*/

        g1.clear(Calendar.MILLISECOND);
        g2.clear(Calendar.MILLISECOND);
        return g1.equals(g2);
    }

    /**
     * getElapsedDays devuelve el numero de dias que han transcurrido desde la
     * fecha date hasta el momento de invocar el metodo
     *
     * @param date Date
     * @return long
     */
    public static long getElapsedDays(Date date) {
        return elapsedDate(date, Calendar.DATE);
    }

    /**
     * getElapsedDays devuelve el numero de dias que han transcurrido desde la
     * fecha d1 hasta la fecha d2
     *
     * @param d1 Date
     * @param d2 Date
     * @return long
     */
    public static long getElapsedDays(Date d1, Date d2) {
        return elapsedDate(d1, d2, Calendar.DATE);
    }

    public static long getElapsedMonths(Date date) {
        return elapsedDate(date, Calendar.MONTH);
    }

    public static long getElapsedMonths(Date d1, Date d2) {
        return elapsedDate(d1, d2, Calendar.MONTH);
    }

    public static long getElapsedYears(Date date) {
        return elapsedDate(date, Calendar.YEAR);
    }

    public static long getElapsedYears(Date d1, Date d2) {
        return elapsedDate(d1, d2, Calendar.YEAR);
    }

    private static long elapsedDate(GregorianCalendar g1, GregorianCalendar g2, int type) {
        GregorianCalendar gc1, gc2;
        int elapsed = 0;
        // Create copies since we will be clearing/adding
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        if (type == Calendar.MONTH || type == Calendar.YEAR) {
            gc1.clear(Calendar.DATE);
            gc2.clear(Calendar.DATE);
        }
        if (type == Calendar.YEAR) {
            gc1.clear(Calendar.MONTH);
            gc2.clear(Calendar.MONTH);
        }
        while (gc1.before(gc2)) {
            gc1.add(type, 1);
            elapsed++;
        }
        return elapsed;
    }

    private static long elapsedDate(Date date, int type) {
        return elapsedDate(date, new Date(), type);
    }

    private static long elapsedDate(Date d1, Date d2, int type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        return elapsedDate(g1, g2, type);
    }

    public static long getElapsedSeconds(Date date) {
        return elapsedTime(date, Calendar.SECOND);
    }

    public static long getElapsedSeconds(Date d1, Date d2) {
        return elapsedTime(d1, d2, Calendar.SECOND);
    }

    public static long getElapsedMinutes(Date date) {
        return elapsedTime(date, Calendar.MINUTE);
    }

    public static long getElapsedMinutes(Date d1, Date d2) {
        return elapsedTime(d1, d2, Calendar.MINUTE);
    }

    public static long getElapsedHours(Date date) {
        return elapsedTime(date, Calendar.HOUR);
    }

    public static long getElapsedHours(Date d1, Date d2) {
        return elapsedTime(d1, d2, Calendar.HOUR);
    }

    private static long elapsedTime(GregorianCalendar g1, GregorianCalendar g2, int type) {
        GregorianCalendar gc1, gc2;
        int elapsed = 0;
        // Create copies since we will be clearing/adding
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
        } else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        if (type == Calendar.MINUTE || type == Calendar.HOUR) {
            gc1.clear(Calendar.SECOND);
            gc2.clear(Calendar.SECOND);
        }
        if (type == Calendar.HOUR) {
            gc1.clear(Calendar.MINUTE);
            gc2.clear(Calendar.MINUTE);
        }
        while (gc1.before(gc2)) {
            gc1.add(type, 1);
            elapsed++;
        }
        return elapsed;
    }

    private static long elapsedTime(Date date, int type) {
        return elapsedTime(date, new Date(), type);
    }

    private static long elapsedTime(Date d1, Date d2, int type) {
        Calendar now = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        now.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE),
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        return elapsedTime(g1, g2, type);
    }

    public static Date crearFecha(String fecha) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = (Date) formatter.parse(fecha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public static String crearFechaString(Date fecha) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = "";
        try {
            date = formatter.format(fecha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public static String crearFechaStringFormato(Date fecha) {
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String date = "";
        try {
            date = formatter.format(fecha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public static String crearFechaStringGuion(Date fecha) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = "";
        try {
            date = formatter.format(fecha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }

    public static Date convertirGregorianADate(GregorianCalendar fecha) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = (Date) fecha.getTime();
        } catch (Exception e) {
            System.out.println(e);
        }
        return date;
    }
    // Finalidad: Calcular el dia ultimo de mes dada una fecha.

    public static Date obtenerUltimoDeMes(Date fecha) {
        Calendar now = Calendar.getInstance();
        now.setTime(fecha);
        int mes = now.get(Calendar.MONTH);
        String aux = "";
        String dias[] = {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
        String meses[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        if (mes == 1) {
            if (((now.get(Calendar.YEAR) % 4 == 0) && (now.get(Calendar.YEAR) % 100 != 0)) || (now.get(Calendar.YEAR) % 400 == 0)) {
                aux = aux + "29";
            } else {
                aux = aux + "28";
            }
        } else {
            aux = aux + dias[mes];
        }
        aux = aux + "/" + String.valueOf(meses[mes]) + "/" + String.valueOf(now.get(Calendar.YEAR));
        return crearFecha(aux);
    }

    // Finalidad: Calcular el ultimo dia del mes dado el mes.
    public static Date obtenerUltimoDiaMes(int mes) {
        Calendar now = Calendar.getInstance();
        String aux = "";
        String dias[] = {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
        String meses[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        if (mes == 2) {
            if (((now.get(Calendar.YEAR) % 4 == 0) && (now.get(Calendar.YEAR) % 100 != 0)) || (now.get(Calendar.YEAR) % 400 == 0)) {
                aux = aux + "29";
            } else {
                aux = aux + "28";
            }
        } else {
            aux = aux + dias[mes - 1];
        }
        aux = aux + "/" + String.valueOf(meses[mes - 1]) + "/" + String.valueOf(now.get(Calendar.YEAR));
        return crearFecha(aux);
    }

    public static String obtenerUltimoDiayMes(int mes) {
        Calendar now = Calendar.getInstance();
        String aux = "";
        String dias[] = {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
        String meses[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        if (mes == 2) {
            if (((now.get(Calendar.YEAR) % 4 == 0) && (now.get(Calendar.YEAR) % 100 != 0)) || (now.get(Calendar.YEAR) % 400 == 0)) {
                aux = aux + "29";
            } else {
                aux = aux + "28";
            }
        } else {
            aux = aux + dias[mes - 1];
        }
        aux = aux + "/" + String.valueOf(meses[mes - 1]);
        return aux;
    }

    public static Date fechaMas(Date fecha, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }

    /**
     * getNameMonth() Recibe un mes (integer) {de 0 a 11} Devuelve el nombre del
     * mes (string)
     *
     * @param month (int)
     * @return name (String)
     */
    public static String getNameMonth(int month) {
        String meses[] = {"", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        return meses[month];
    }

    public static int getMonthInt(String month) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("ENERO", 1);
        hm.put("FEBRERO", 2);
        hm.put("MARZO", 3);
        hm.put("ABRIL", 4);
        hm.put("MAYO", 5);
        hm.put("JUNIO", 6);
        hm.put("JULIO", 7);
        hm.put("AGOSTO", 8);
        hm.put("SEPTIEMBRE", 9);
        hm.put("OCTUBRE", 10);
        hm.put("NOVIEMBRE", 11);
        hm.put("DICIEMBRE", 12);
        return hm.get(month);
    }

    public static int getYear(Date fecha) {
        Calendar auxDate = Calendar.getInstance();
        auxDate.setTime(fecha);
        return auxDate.get(Calendar.YEAR);
    }

    public static int getMonth(Date fecha) {
        Calendar auxDate = Calendar.getInstance();
        auxDate.setTime(fecha);
        //int meses[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        //return meses[auxDate.get(Calendar.MONTH)];
        return auxDate.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date fecha) {
        Calendar auxDate = Calendar.getInstance();
        auxDate.setTime(fecha);
        //int meses[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        //return meses[auxDate.get(Calendar.MONTH)];
        return auxDate.get(Calendar.DAY_OF_MONTH);
    }

    public static String getTimeAgo(Date fecha1, Date fecha2) {
        String value = "";
        long days = getElapsedDays(fecha1, fecha2);
        long hours = getElapsedHours(fecha1, fecha2);
        long minutes = getElapsedMinutes(fecha1, fecha2);

        if (days != 0) {
            if (days == 1)
                value = days + " day ";
            else if (days <= 30)
                value = days + " days ";
        }

        if (hours != 0) {
            if (hours == 1)
                value += hours + " hour ";
            else if (hours <= 24)
                value += hours + " hours ";
        }

        if (minutes != 0) {
            if (minutes == 1)
                value += minutes + " minute ";
            else if (minutes <= 60)
                value += minutes + " minutes ";
        } else {
            long seconds = getElapsedSeconds(fecha1, fecha2);
            if (seconds != 0)
                value += seconds + " seconds ";
        }

        value += "ago";
        return value;
    }

    public static Date createDate(int year, int month, int day) {
        String date = day + "-" + month + "-" + year;
        Date utilDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            utilDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilDate;
    }

    public static String getStringDate(Date date) {
        String d = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return d;
    }

    public static String getMonth(int month) {
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
        return monthString;
    }

}
