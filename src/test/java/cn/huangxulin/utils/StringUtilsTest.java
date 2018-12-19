package cn.huangxulin.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class StringUtilsTest {

    private String str;

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(StringUtils.isEmpty(str));
        str = "";
        Assert.assertTrue(StringUtils.isEmpty(str));
        str = " ";
        Assert.assertFalse(StringUtils.isEmpty(str));
        str = "123";
        Assert.assertFalse(StringUtils.isEmpty(str));
    }

    @Test
    public void testIsNotEmpty() {
        Assert.assertFalse(StringUtils.isNotEmpty(str));
        str = "";
        Assert.assertFalse(StringUtils.isNotEmpty(str));
        str = " ";
        Assert.assertTrue(StringUtils.isNotEmpty(str));
        str = "123";
        Assert.assertTrue(StringUtils.isNotEmpty(str));
    }

    @Test
    public void testIsBlank() {
        Assert.assertTrue(StringUtils.isBlank(str));
        str = "";
        Assert.assertTrue(StringUtils.isBlank(str));
        str = " ";
        Assert.assertTrue(StringUtils.isBlank(str));
        str = "123";
        Assert.assertFalse(StringUtils.isBlank(str));
    }

    @Test
    public void testIsNotBlank() {
        Assert.assertFalse(StringUtils.isNotBlank(str));
        str = "";
        Assert.assertFalse(StringUtils.isNotBlank(str));
        str = " ";
        Assert.assertFalse(StringUtils.isNotBlank(str));
        str = "123";
        Assert.assertTrue(StringUtils.isNotBlank(str));
    }

}
