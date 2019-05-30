package cn.huangxulin.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class DateUtilsTest {

    private Date currentDate = new Date();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    @Test
    public void testGetDayStart() {
        Date date = DateUtils.getDayStart(currentDate);
        System.out.println(sdf.format(date));
    }

    @Test
    public void testGetDayEnd() {
        Date date = DateUtils.getDayEnd(currentDate);
        System.out.println(sdf.format(date));
    }

    @Test
    public void testAddDay() {
        Date date = DateUtils.addDay(currentDate, -7);
        System.out.println(sdf.format(date));
    }

    @Test
    public void testAddMinutes() {
        Date date = DateUtils.addMinutes(currentDate, 15);
        System.out.println(sdf.format(date));
    }
}
