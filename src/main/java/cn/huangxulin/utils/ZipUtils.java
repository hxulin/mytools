package cn.huangxulin.utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.util.*;

/**
 * 功能描述: 文件压缩和解压的工具类
 *
 * @author hxulin
 */
public final class ZipUtils {

    private ZipUtils() {

    }

    /**
     * 创建基本的压缩、解压参数
     */
    private static ZipParameters createBaseParameters() {
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        return parameters;
    }

    /**
     * 压缩单个文件
     *
     * @param srcFileName  待压缩文件名，如：C:/zipTest/srcFile.txt
     * @param destFileName 压缩生成的文件名，如：C:/zipTest/target.zip
     */
    public static void zip(String srcFileName, String destFileName) throws ZipException {
        Set<String> singleton = Collections.singleton(srcFileName);
        zip(singleton, destFileName);
    }

    /**
     * 压缩多个文件
     *
     * @param srcFileNames 多个待压缩文件的全路径名
     * @param destFileName 压缩生成的文件的全路径名
     */
    public static void zip(Set<String> srcFileNames, String destFileName) throws ZipException {
        zip(srcFileNames, destFileName, null);
    }

    /**
     * 加密压缩单个文件
     *
     * @param srcFileName  待压缩文件名，如：C:/zipTest/srcFile.txt
     * @param destFileName 压缩生成的文件名，如：C:/zipTest/target.zip
     * @param password     压缩密码
     */
    public static void zip(String srcFileName, String destFileName, String password) throws ZipException {
        Set<String> srcFileNames = Collections.singleton(srcFileName);
        zip(srcFileNames, destFileName, password);
    }

    /**
     * 加密压缩多个文件
     *
     * @param srcFileNames 多个待压缩文件的全路径名
     * @param destFileName 压缩生成的文件的全路径名
     * @param password     压缩密码
     */
    public static void zip(Set<String> srcFileNames, String destFileName, String password) throws ZipException {
        ArrayList<File> srcFiles = new ArrayList<>();
        ZipFile zipFile = new ZipFile(destFileName);
        ZipParameters parameters = createBaseParameters();
        if (password != null) {
            // 设置加密参数
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            parameters.setPassword(password);
        }
        for (String srcFileName : srcFileNames) {
            srcFiles.add(new File(srcFileName));
        }
        zipFile.addFiles(srcFiles, parameters);
    }

    /**
     * 压缩文件夹
     *
     * @param folderName   待压缩的文件夹，如：C:/zipTest/srcFileFolder
     * @param destFileName 压缩生成的文件名，如：C:/zipTest/target.zip
     */
    public static void zipFolder(String folderName, String destFileName) throws ZipException {
        zipFolder(folderName, destFileName, null);
    }

    /**
     * 加密压缩文件夹
     *
     * @param folderName   待压缩的文件夹，如：C:/zipTest/srcFileFolder
     * @param destFileName 压缩生成的文件名，如：C:/zipTest/target.zip
     * @param password     压缩密码
     */
    public static void zipFolder(String folderName, String destFileName, String password) throws ZipException {
        ZipFile zipFile = new ZipFile(destFileName);
        ZipParameters parameters = createBaseParameters();
        if (password != null) {
            // 设置加密参数
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            parameters.setPassword(password);

        }
        zipFile.addFolder(folderName, parameters);
    }

    /**
     * 解压缩文件
     *
     * @param zipFileName  待解压的文件名，如：C:/zipTest/target.zip
     * @param targetFolder 压缩后存放的路径，如：C:/zipTest/unZip
     */
    public static void unZip(String zipFileName, String targetFolder) throws ZipException {
        unZip(zipFileName, targetFolder, null);
    }

    /**
     * 解压缩文件
     *
     * @param zipFile      待解压缩的文件
     * @param targetFolder 压缩文件存放的路径，如：C:/zipTest/unZip
     */
    public static void unZip(File zipFile, String targetFolder) throws ZipException {
        unZip(zipFile, targetFolder, null);
    }

    /**
     * 解压缩加密的文件
     *
     * @param zipFileName  待解压的文件名，如：C:/zipTest/target.zip
     * @param targetFolder 解压后的存放路径，如：C:/zipTest/unZip
     * @param password     解压密码
     */
    public static void unZip(String zipFileName, String targetFolder, String password) throws ZipException {
        ZipFile zipFile = new ZipFile(zipFileName);
        if (password != null && zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(targetFolder);
    }

    /**
     * 解压缩加密的文件
     *
     * @param zipFile      待解压缩的文件
     * @param targetFolder 解压后的存放路径，如：C:/zipTest/unZip
     * @param password     解压密码
     */
    public static void unZip(File zipFile, String targetFolder, String password) throws ZipException {
        unZip(zipFile.getAbsolutePath(), targetFolder, password);
    }

}
