package cn.huangxulin.utils;

/**
 * 功能描述: 字符串处理工具类
 *
 * @author hxulin
 */
public final class StringUtils {

    private StringUtils() {

    }

    /**
     * 判断字符串为空
     *
     * @param str 待判断的字符串
     * @return 字符串为null或者长度为0返回true，否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * 判断字符串非空
     *
     * @param str 待判断的字符串
     * @return 字符串不为null并且长度不为0返回true，否则返回false
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是空白字符串
     *
     * @param str 待判断的字符串
     * @return 字符串为null或者长度为0或者内容为空白，返回true，否则返回false
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串不是空白字符串
     *
     * @param str 待判断的字符串
     * @return 字符串不为null并且长度不为0并且内容不为空白，返回true，否则返回false
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
