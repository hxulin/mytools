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

    /**
     * 加密压缩和解压的密码
     */
    private static final String ZIP_PASSWORD = "password";

    /**
     * 压缩最终生成的文件名
     */
    private String destFileName = "zipTest/target.zip";

    /**
     * 解压缩时，文件解压后的存放路径
     */
    private String targetFolder = "zipTest/unZip";

    /**
     * 测试压缩单个文件
     */
    @Test
    public void test1() throws Exception {
        String srcFileName = "zipTest/srcFileFolder/workspace/hello-world.jpeg";
        ZipUtils.zip(srcFileName, destFileName);
    }

    /**
     * 测试压缩多个文件
     */
    @Test
    public void test2() throws Exception {
        Set<String> srcFileNames = new HashSet<>();
        srcFileNames.add("zipTest/srcFileFolder/workspace/hello-world.jpeg");
        srcFileNames.add("zipTest/srcFileFolder/settings.xml");
        ZipUtils.zip(srcFileNames, destFileName);
    }

    /**
     * 测试加密压缩单个文件
     */
    @Test
    public void test3() throws Exception {
        String srcFileName = "zipTest/srcFileFolder/workspace/hello-world.jpeg";
        ZipUtils.zip(srcFileName, destFileName, ZIP_PASSWORD);
    }

    /**
     * 测试加密压缩多个文件
     */
    @Test
    public void test4() throws Exception {
        Set<String> srcFileNames = new HashSet<>();
        srcFileNames.add("zipTest/srcFileFolder/workspace/hello-world.jpeg");
        srcFileNames.add("zipTest/srcFileFolder/settings.xml");
        ZipUtils.zip(srcFileNames, destFileName, ZIP_PASSWORD);
    }

    /**
     * 测试压缩文件夹
     */
    @Test
    public void test5() throws Exception {
        String folderName = "zipTest/srcFileFolder";
        ZipUtils.zipFolder(folderName, destFileName);
    }

    /**
     * 测试加密压缩文件夹
     */
    @Test
    public void test6() throws Exception {
        String folderName = "zipTest/srcFileFolder";
        ZipUtils.zipFolder(folderName, destFileName, ZIP_PASSWORD);
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
        ZipUtils.unZip(destFileName, targetFolder, ZIP_PASSWORD);
    }

    /**
     * 测试解压缩加密的文件
     */
    @Test
    public void test10() throws Exception {
        ZipUtils.unZip(new File(destFileName), targetFolder, ZIP_PASSWORD);
    }

}
