package com.example.test.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtils {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfYearMonth = new SimpleDateFormat("yyyy-MM");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");

	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private final static SimpleDateFormat sdfTimeDetail =new SimpleDateFormat(
			"yyyyMMdd HH:mm:ss.SSS");

	private final static SimpleDateFormat sdfTimeMs =new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");

	/**
	 * 获取YYYY格式
	 *
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 *
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}


	/**
	 * 获取YYYY-MM格式
	 *
	 * @return
	 */
	public static String getYearMonth() {
		return sdfYearMonth.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 *
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}



	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 *
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * 获取yyyyMMdd HH:mm:ss.SSS
	 * @return
	 */
	public static String getTimeDetail(){
		return sdfTimeDetail.format(new Date());
	}

	/**
	 * @Description: 获取yyyyMMddHHmmssSSS
	 * @author zhangjiahu
	 * @date 2017年5月18日 下午6:32:22
	 * @return String
	 */
	public static String getTimeMs(){
		return sdfTimeMs.format(new Date());
	}

	/**
	 * 获取当前时间的毫秒数
	 *
	 * @return
	 */
	public static String getMsTime() {
		return ""+new Date().getTime();
	}

	/**
	* @Title: compareDate
	* @Description:
	* @param s
	* @param e
	* @return boolean
	* @throws
	* @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期 yyyy-MM-dd
	 *
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fomatString(Date date){
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(date);
	}

	public static String fomatString(Date date, String format){
		DateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}

	/**
	 * 格式化日期，yyyy-MM-dd
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String fomarString(String date) throws ParseException{
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(fmt.parse(date));
	}

	public static Date fomatDate(String date,String fmt){
		try {
			DateFormat df = new SimpleDateFormat(fmt);
			return df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 *
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 获取某天前几天日期，后几天日期
     * @param day 传入日期
     * @param n 传入天数 正数-当天之后；负数-当天之前
     * @return yyyy-MM-dd
     */
    public static String getSomeDay(String day,int n){
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        //得到当前时间，+- n天
        calendar.add(Calendar.DAY_OF_MONTH, n);
        String dates = sim.format(calendar.getTime());
        return dates;
    }

    /**
     * 获取某天前几天日期，后几天日期
     * @param day 传入日期
     * @param n 传入天数 正数-当天之后；负数-当天之前
     * @return yyyy-MM-dd
     */
    public static Date getSomeDay(Date day,int n){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(day);
    	//得到当前时间，+- n天
    	calendar.add(Calendar.DAY_OF_MONTH, n);
    	return calendar.getTime();
    }

    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 获取当前日期是周几
     * @return
     */
    public static String getDayWeek(){
    	Date date=new Date();
    	SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
    	return dateFm.format(date);
    }

    /**
     * 获取日期是周几
     * @return
     */
    public static String getDayWeek(String strDate){
    	Date date = fomatDate(strDate);
    	SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
    	return dateFm.format(date);
    }

    /**
     * 验证是否为周末（周六或周日）
     * @return
     */
    public static boolean isWeekend(String strDate){
    	Date date = fomatDate(strDate);
    	Calendar cal = Calendar.getInstance(); // 获得一个日历
    	cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return w == 0 || w == 6;
    }

	public static boolean isWeekend(Date date){
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return w == 0 || w == 6;
	}

    /**
     * 当前时间减去打卡时间
     * 日期相减得分钟
     * @param beginDateStr
     */
    public static long getMinute(String beginDateStr){
    	long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = null;
        Date endDate = null;

            try {
            	beginDate = format.parse(beginDateStr);
				endDate = format.parse(sdfTime.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day = (endDate.getTime()-beginDate.getTime())/(60000);
        return day;
    }

    /**
     * 打卡时间减去当前时间
     * 日期相减得分钟
     * @param beginDateStr
     * @return beginDate - now
     */
    public static long getMinutes(String beginDateStr){
    	long day=0;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date beginDate = null;
    	Date endDate = null;

    	try {
    		beginDate = format.parse(beginDateStr);
    		endDate = format.parse(sdfTime.format(new Date()));
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	day = (beginDate.getTime()-endDate.getTime())/(60000);
    	return day;
    }

    /**
     * 时间相加
     * @param dateStr
     * @param num 单位分钟
     * @return
     */
    public static String addMinute(String dateStr,int num){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = null;
    	Date addDate = null;

    	try {
    		date = format.parse(dateStr);
    		addDate =  new Date(date.getTime() + num*60000);
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return format.format(addDate);
    }

    /**
     * 日期相减得分钟
     * 第1个参数减去第2个参数
     * 结果大于0，代表前者比后者大
     * @param beginDateStr,endDateStr
     * @return beginDate - endDate
     */
    public static long getMinute(String beginDateStr,String endDateStr){
    	long day=0;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date beginDate = null;
    	Date endDate = null;

    	try {
    		beginDate = format.parse(beginDateStr.substring(0, beginDateStr.length()-2)+"00");
    		endDate = format.parse(endDateStr.substring(0,endDateStr.length()-2)+"00");
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	day = (beginDate.getTime()-endDate.getTime())/(60000);
    	return day;
    }

    /**
     * 日期相减得分钟
     * 第2个参数减去第1个参数
     * 结果大于0，代表后者比前者大
     * @param beginDateStr 开始时间，例09:30
     * @param endDateStr 结束时间，例12:00
     * @return endDate - beginDate
     */
    public static long getMinutes(String beginDateStr,String endDateStr){
    	long day=0;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date beginDate = null;
    	Date endDate = null;

    	try {
    		beginDate = format.parse(sdfDay.format(new Date())+" "+beginDateStr+":00");
    		endDate = format.parse(sdfDay.format(new Date())+" "+endDateStr+":00");
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	day = (endDate.getTime()-beginDate.getTime())/(60000);
    	return day;
    }

    /**
     * 获取两个日期之间的日期
     * @param start
     * @param end
     * @return
     */
    public static List<String> getBetweenDates(String start, String end) {
		List<String> result = new ArrayList<String>();
		try {
			Date startDate = sdfDay.parse(start);
			Date endDate = sdfDay.parse(end);
			Calendar tempStart = Calendar.getInstance();
			tempStart.setTime(startDate);
			tempStart.add(Calendar.DAY_OF_YEAR, 1);

			Calendar tempEnd = Calendar.getInstance();
			tempEnd.setTime(endDate);
			while (tempStart.before(tempEnd)) {
				result.add(sdfDay.format(tempStart.getTime()));
				tempStart.add(Calendar.DAY_OF_YEAR, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
	}

    /**
     * 获取两个月份之间的月份
     * @param startMonth
     * @param endMonth
     * @return
     */
    public static List<String> getMonthBetween(String startMonth, String endMonth) {
    	List<String> result = new ArrayList<String>();
	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();

	    try {
			min.setTime(sdfYearMonth.parse(startMonth));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
			max.setTime(sdfYearMonth.parse(endMonth));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
			Calendar curr = min;
			while (curr.before(max)) {
				result.add(sdfYearMonth.format(curr.getTime()));
				curr.add(Calendar.MONTH, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return result;
    }

    /**
	 *
	 * @param time 时段。格式：mm:ss
	 * @return
	 * @throws Exception
	 */
    public static int getTotalMinute(String time) throws Exception {
    	if(StringUtils.isEmpty(time)) {
			return 0;
		}
		String[] hourAndMinute = time.split(":");
		if(hourAndMinute.length != 2) {
			throw new Exception("时间格式不正确，应为HH:mm！");
		}
		int hour = Integer.parseInt(hourAndMinute[0]);
		if(hour < 0 || hour > 23) {
			throw new Exception("小时范围0-23！");
		}
		int minute = Integer.parseInt(hourAndMinute[1]);
		if(minute < 0 || minute > 59) {
			throw new Exception("分钟范围0-59");
		}
		return hour * 60 + minute;
	}

    /**
	 *
	 * @param minute 时段。格式：mm:ss
	 * @return
	 * @throws Exception
	 */
    public static String fomart(int minute) throws Exception {
    	return String.format("%02d:%02d", minute / 60, minute % 60);
	}

    /**
     * 获取上一个月
     *
     * @return yyyy-MM
     */
    @SuppressWarnings("static-access")
	public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, -1);
        String lastMonth = sdfYearMonth.format(cal.getTime());
        return lastMonth;
    }
    /**
     * 获取上几个月份
     * i 上几个
     *
     * @return yyyy-MM
     */
    @SuppressWarnings("static-access")
    public static String getLastMonth2(int i) {
    	Calendar cal = Calendar.getInstance();
    	cal.add(cal.MONTH, -i);
    	String lastMonth = sdfYearMonth.format(cal.getTime());
    	return lastMonth;
    }

    /**
     *
     * 描述:获取下一个月.
     *
     * @return yyyy年MM月
     */
    @SuppressWarnings("static-access")
	public static String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy年MM月");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }

	public static Date getFirstDayOfMonth(int year, int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1, 0, 0, 0);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date first = calendar.getTime();
		return first;
	}

	public static Date getLastDayOfMonth(int year, int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1, 23 , 59 , 59);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		Date last = calendar.getTime();
		return last;
	}

	public static Date getDateOfYMD(int year, int month, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, 0, 0, 0);
		calendar.add(Calendar.MONTH, -1);
		Date date = calendar.getTime();
		return date;
	}

	public static int getDifferentDays(Date date1,Date date2)
	{
		int days = (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
		return days;
	}

	public static int getWeek() {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	public int getWeekOfDate(Date date) {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	 public static String strToDateFormat(String date) throws ParseException {
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	       formatter.setLenient(false);
	       Date newDate= formatter.parse(date);
	       formatter = new SimpleDateFormat("yyyy-MM-dd");
	       return formatter.format(newDate);
	   }

//	public static void main(String a[]){
//
//			System.err.println(getSomeDay(new Date(),-1));
//
//	}

	public static Date addDays(Date startDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.DAY_OF_MONTH, days);

		return c.getTime();
	}

	public static Date getHMS(Date date, int hh, int mm, int ss){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hh);
		cal.set(Calendar.MINUTE, mm);
		cal.set(Calendar.SECOND, ss);
		return cal.getTime();
	}

    //判断选择的日期是否是今天
    public static boolean isToday(long time) {
        return isThisTime(time, "yyyy-MM-dd");
    }

    //判断选择的日期是否是本周
    public static boolean isThisWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == currentWeek) {
            return true;
        }
        return false;
    }

    //判断选择的日期是否是上周
    public static boolean isLastWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        int lastWeek =currentWeek-1;
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == lastWeek) {
            return true;
        }
        return false;
    }


    //判断选择的日期是否是本月
    public static boolean isThisMonth(long time) {
        return isThisTime(time, "yyyy-MM");
    }

    public static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }


	public static LocalDateTime parseLocalDateTime(String dateStr){
    	return LocalDateTime.parse(dateStr, dateStr.contains("T")? DateTimeFormatter.ISO_LOCAL_DATE_TIME:DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

    /**
     * 时间转时间戳
     * @param dateTime
     * @return
     */
	public static Long localDateTime2Timestamp(LocalDateTime dateTime){
        return dateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 日期转时间戳
     * @param date
     * @return
     */
    public static Long localDate2Timestamp(LocalDate date){
        return date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * 时间戳转时间
     * @param timestamp
     * @return
     */
    public static LocalDateTime timestamp2LocalDateTime(Long timestamp){
        return  Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 时间戳转日期
     * @param timestamp
     * @return
     */
    public static LocalDate timestamp2LocalDate(Long timestamp){
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

}
