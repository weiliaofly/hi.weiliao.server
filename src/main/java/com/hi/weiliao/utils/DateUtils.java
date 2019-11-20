package com.hi.weiliao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 *
 * @auth LD
 * @date 2019-01-03
 *
 * */
public class DateUtils {

    //两种常见日期类型
    public static final DateFormat YYYYMMDDHHMISS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

    public static final String[] WEEKS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    //日期类型
    public enum DateType{
        YEAR(365*24*60*60*1000L),
        MONTH(30*24*60*60*1000L),
        DAY(24*60*60*1000L),
        HOUR(60*60*1000L),
        MINUTE(60000L),
        SECOND(1000L),
        MILLISECOND(1L);

        private Long index;

        DateType(Long index){
            this.index = index;
        }

        public Long getIndex(){
           return this.index;
        }

    }

    /*===============================获取当前时间==================================*/

    /**
     * 查询当前String时间
     *
     * @param df 时间模板
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String currentTimeString(DateFormat df){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(new Date());
    }

    /**
     * 查询当前Long时间戳
     *
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long currentTimeLong(){
        return System.currentTimeMillis();
    }

    /**
     * 查询当前Date时间
     *
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date currentTimeDate(){
        return new Date();
    }

    /**
     * 获取年月日时分秒By String
     *
     * @return String类型的时间 yyyy-MM-dd HH:mm:ss格式
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Map<String, Object> timeDetail(String date) throws ParseException{
        Map<String, Object> result = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YYYYMMDDHHMISS.parse(date));

        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK) == 1? 7: calendar.get(Calendar.DAY_OF_WEEK);

        result.put("year", calendar.get(Calendar.YEAR));
        result.put("month", calendar.get(Calendar.MONTH) + 1);
        result.put("dayYear", calendar.get(Calendar.DAY_OF_YEAR));
        result.put("dayMonth", calendar.get(Calendar.DAY_OF_MONTH));
        result.put("dayWeekInt", calendar.get(Calendar.DAY_OF_WEEK));
        result.put("dayWeekString", WEEKS[dayWeek-2]);
        result.put("hour", calendar.get(Calendar.HOUR_OF_DAY));
        result.put("minute", calendar.get(Calendar.MINUTE));
        result.put("second", calendar.get(Calendar.SECOND));
        return result;
    }

    /**
     * 获取年月日时分秒By Long
     *
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Map<String, Object> timeDetail(Long date){
        Map<String, Object> result = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));

        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK) == 1? 7: calendar.get(Calendar.DAY_OF_WEEK);

        result.put("year", calendar.get(Calendar.YEAR));
        result.put("month", calendar.get(Calendar.MONTH) + 1);
        result.put("dayYear", calendar.get(Calendar.DAY_OF_YEAR));
        result.put("dayMonth", calendar.get(Calendar.DAY_OF_MONTH));
        result.put("dayWeekInt", calendar.get(Calendar.DAY_OF_WEEK));
        result.put("dayWeekString", WEEKS[dayWeek-2]);
        result.put("hour", calendar.get(Calendar.HOUR_OF_DAY));
        result.put("minute", calendar.get(Calendar.MINUTE));
        result.put("second", calendar.get(Calendar.SECOND));
        return result;
    }

    /**
     * 获取年月日时分秒By Date
     *
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Map<String, Object> timeDetail(Date date){
        Map<String, Object> result = new LinkedHashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK) == 1? 7: calendar.get(Calendar.DAY_OF_WEEK);

        result.put("year", calendar.get(Calendar.YEAR));
        result.put("month", calendar.get(Calendar.MONTH) + 1);
        result.put("dayYear", calendar.get(Calendar.DAY_OF_YEAR));
        result.put("dayMonth", calendar.get(Calendar.DAY_OF_MONTH));
        result.put("dayWeekInt", calendar.get(Calendar.DAY_OF_WEEK));
        result.put("dayWeekString", WEEKS[dayWeek - 2]);
        result.put("hour", calendar.get(Calendar.HOUR_OF_DAY));
        result.put("minute", calendar.get(Calendar.MINUTE));
        result.put("second", calendar.get(Calendar.SECOND));
        return result;
    }

    /**
     * 获取输入时间当前或前后几周的日期（周一为第一天）
     *
     * @param date 输入时间
     * @param after 推后几周，当前为0，推后为正，提前为负
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Map<String, Object> timeWeekDays(String date, int after) throws ParseException{
        Map<String, Object> result = new LinkedHashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YYYYMMDDHHMISS.parse(date));

        //日历提前或推后
        calendar.add(Calendar.DAY_OF_YEAR, after*7);

        //获取周一时间
        if(1 == calendar.get(Calendar.DAY_OF_WEEK)){
            calendar.add(Calendar.DAY_OF_YEAR, -6);
        }
        calendar.add(Calendar.DAY_OF_YEAR, 2 - calendar.get(Calendar.DAY_OF_WEEK));

        result.put(WEEKS[0], YYYYMMDD.format(calendar.getTime()));
        for(int i=1; i < 7; i++){
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            result.put(WEEKS[i], YYYYMMDD.format(calendar.getTime()));
        }
        return result;
    }

    /**
     * 获取输入时间当前或前后几天的日期
     *
     * @param date 输入时间
     * @param after 推后几天，当前为0，推后为正，提前为负
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String timeDays(String date, int after) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YYYYMMDDHHMISS.parse(date));

        //日历提前或推后
        calendar.add(Calendar.DAY_OF_YEAR, after);

        return YYYYMMDD.format(calendar.getTime());
    }

    /*===============================时间转换==================================*/

    /**
     * Long --> String
     *
     * @param df 时间模板
     * @param date 需要转换的时间参数
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String timeLong2String(DateFormat df, Long date){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(new Date(date));
    }

    /**
     * Date --> String
     *
     * @param df 时间模板
     * @param date 需要转换的时间参数
     * @return String类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static String timeDate2String(DateFormat df, Date date){
        if(df == null){
            df = YYYYMMDDHHMISS;
        }
        return df.format(date);
    }

    /**
     * Date --> Long
     *
     * @param date 需要转换的时间参数
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long timeDate2Long(Date date){
        return date.getTime();
    }

    /**
     * String --> Long
     *
     * @param date 需要转换的时间参数
     * @return Long类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Long timeString2Long(String date) throws ParseException{
        return YYYYMMDDHHMISS.parse(date).getTime();
    }

    /**
     * Long --> Date
     *
     * @param date 需要转换的时间参数
     * @return Date类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date timeLong2Date(Long date){
        return new Date(date);
    }

    /**
     * String --> Date
     *
     * @param date 需要转换的时间参数
     * @return Date类型的时间
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Date timeString2Date(String date) throws ParseException{
        return YYYYMMDDHHMISS.parse(date);
    }

    /*===============================时间计算==================================*/

    /**
     * String时间差(end - begin)
     *
     * @param begin 开始时间
     * @param end 结束时间
     * @param dateType 返回时间类型（年月日时分秒）,从DateType中获取 DateType.YEAR.getIndex();
     * @return Double型时间差
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Double timeMinus(String begin, String end, Long dateType) throws ParseException{
        Long resultMillisecond = YYYYMMDDHHMISS.parse(end).getTime() - YYYYMMDDHHMISS.parse(begin).getTime();
        return Math.round((resultMillisecond*1.0/dateType) * 100)/100.0;
    }

    /**
     * Long时间差(end - begin)
     *
     * @param begin 开始时间
     * @param end 结束时间
     * @param dateType 返回时间类型（年月日时分秒）,从DateType中获取 DateType.YEAR.getIndex();
     * @return Double型时间差
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Double timeMinus(Long begin, Long end, Long dateType){
        Long resultMillisecond = end - begin;
        return Math.round((resultMillisecond*1.0/dateType) * 100)/100.0;
    }

    /**
     * Date时间差(end - begin)
     *
     * @param begin 开始时间
     * @param end 结束时间
     * @param dateType 返回时间类型（年月日时分秒）,从DateType中获取 DateType.YEAR.getIndex();
     * @return Double型时间差
     *
     * @auth LD
     * @date 2019-01-03
     *
     * */
    public static Double timeMinus(Date begin, Date end, Long dateType){
        Long resultMillisecond = end.getTime() - begin.getTime();
        return Math.round((resultMillisecond*1.0/dateType) * 100)/100.0;
    }

    /**
     * 获取输入时间当月天数
     *
     * @param date 输入时间
     *
     * @auth LD
     * @date 2019-01-08
     *
     * */
    public static Integer timeMonthDays(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(YYYYMMDDHHMISS.parse(date));
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
