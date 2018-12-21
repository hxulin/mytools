package cn.huangxulin.utils;

import org.junit.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class ZipUtilsTest {

    private String destFileName = "D:/zipTest/target.zip";
    private String targetFolder = "D:/zipTest/unZip";

    /**
     * 测试压缩单个文件
     */
    @Test
    public void test1() throws Exception {
        String srcFileName = "D:\\zipTest\\srcFileFolder\\workspace\\hello-world.jpeg";
        ZipUtils.zip(srcFileName, destFileName);
    }

    /**
     * 测试压缩多个文件
     */
    @Test
    public void test2() throws Exception {
        Set<String> srcFileNames = new HashSet<>();
        srcFileNames.add("D:\\zipTest\\srcFileFolder\\workspace\\hello-world.jpeg");
        srcFileNames.add("D:\\zipTest\\srcFileFolder2\\heart.py");
        ZipUtils.zip(srcFileNames, destFileName);
    }

    /**
     * 测试加密压缩单个文件
     */
    @Test
    public void test3() throws Exception {
        String srcFileName = "D:\\zipTest\\srcFileFolder\\workspace\\hello-world.jpeg";
        ZipUtils.zip(srcFileName, destFileName, "password");
    }

    /**
     * 测试加密压缩多个文件
     */
    @Test
    public void test4() throws Exception {
        Set<String> srcFileNames = new HashSet<>();
        srcFileNames.add("D:\\zipTest\\srcFileFolder\\workspace\\hello-world.jpeg");
        srcFileNames.add("D:\\zipTest\\srcFileFolder2\\heart.py");
        ZipUtils.zip(srcFileNames, destFileName, "password");
    }

    /**
     * 测试压缩文件夹
     */
    @Test
    public void test5() throws Exception {
        String folderName = "D:\\zipTest\\srcFileFolder";
        ZipUtils.zipFolder(folderName, destFileName);
    }

    /**
     * 测试加密压缩文件夹
     */
    @Test
    public void test6() throws Exception {
        String folderName = "D:\\zipTest\\srcFileFolder";
        ZipUtils.zipFolder(folderName, destFileName, "password");
    }

    /**
     * 测试解压缩文件
     */
    @Test
    public void test7() throws Exception {
        ZipUtils.unZip(destFileName, targetFolder);
    }

    /**
     * 测试解压缩文件
     */
    @Test
    public void test8() throws Exception {
        ZipUtils.unZip(new File(destFileName), targetFolder);
    }

    /**
     * 测试解压缩加密的文件
     */
    @Test
    public void test9() throws Exception {
        ZipUtils.unZip(destFileName, targetFolder, "password");
    }

    /**
     * 测试解压缩加密的文件
     */
    @Test
    public void test10() throws Exception {
        ZipUtils.unZip(new File(destFileName), targetFolder, "password");
    }

}
