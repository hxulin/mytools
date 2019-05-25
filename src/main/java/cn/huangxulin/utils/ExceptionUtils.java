package cn.huangxulin.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 功能描述: 异常相关工具类
 *
 * @author hxulin
 */
public final class ExceptionUtils {

    private ExceptionUtils() {

    }

    /**
     * 说明: 获取异常的堆栈信息
     */
    public static String getStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
