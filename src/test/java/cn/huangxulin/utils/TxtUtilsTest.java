package cn.huangxulin.utils;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class TxtUtilsTest {

    @Test
    public void testReadTxt() throws Exception {
        String txtFile = "zipTest/srcFileFolder/settings.xml";
        List<String> linesData = TxtUtils.readTxtToList(new File(txtFile));
        for (String line : linesData) {
            System.out.println(line);
        }
        System.out.println("======== 文件行数：" + linesData.size() + " ========");
    }

    @Test
    public void testWriteTxt() throws Exception {
        String txtFile = "zipTest/write-txt.txt";
        List<String> list = Arrays.asList("ABC", "", "123", "", "");
        TxtUtils.writeTxtFromList(list, new File(txtFile));
    }
}
