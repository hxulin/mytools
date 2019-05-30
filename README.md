# mytools
个人整理的一些常用工具类，方便开发使用

## 环境要求

```
该项目提供的工具类基于 JDK1.8 封装
```

## 工具类清单

### 1、字符串处理

| StringUtils                                       |                          |
| ------------------------------------------------- | ------------------------ |
| public static boolean **isEmpty** (String str)    | 判断字符串是否为空       |
| public static boolean **isNotEmpty** (String str) | 判断字符串是否非空       |
| public static boolean **isBlank** (String str)    | 判断字符串是空白字符串   |
| public static boolean **isNotBlank** (String str) | 判断字符串不是空白字符串 |

### 2、JSON 解析

| JSONUtils                                                    |                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------ |
| public static String **toJson** (Object object)              | 将 Java 对象序列化为 JSON 字符串                       |
| public static String **toJson** (Object object, SerializationStrategy... strategies) | 根据指定的序列化策略，将 Java 对象序列化为 JSON 字符串 |
| public static &lt;T&gt; T **fromJson** (String text, Class&lt;T&gt; clazz) | 将字符串反序列化为 Java 对象                           |

此工具类基于 [fastjson](https://github.com/alibaba/fastjson) 封装，**可以动态指定需要序列化的字段**，轻松解决对象彼此引用时，JSON 序列化无限递归的问题。


```html
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.46</version>
</dependency>
```

### 3、加密、解密

基于 AES 算法封装的加密、解密工具类

| AESUtils                                                     |                  |
| ------------------------------------------------------------ | ---------------- |
| public static String **initKey** ()                          | 生成随机密钥     |
| public static String **initIV** ()                           | 生成初始向量     |
| public static String **encrypt** (String data, String key, String iv) throws Exception | 加密字符串       |
| public static byte[] **encrypt** (byte[] data, String key, String iv) throws Exception | 加密字节数组数据 |
| public static String **decrypt** (String data, String key, String iv) throws Exception | 解密字符串       |
| public static byte[] **decrypt** (byte[] data, String key, String iv) throws Exception | 解密字节数组数据 |

基于 RSA 算法封装的加密、解密工具类

| RSAUtils                                                     |                      |
| ------------------------------------------------------------ | -------------------- |
| public static KeyPair **initKey** ()                         | 生成随机密钥对       |
| public static String **getPublicKey** (KeyPair keyPair)      | 获取公钥             |
| public static String **getPrivateKey** (KeyPair keyPair)     | 获取私钥             |
| public static String **encryptByPublicKey** (String data, String key) throws Exception | 使用公钥加密字符串   |
| public static byte[] **encryptByPublicKey** (byte[] data, String key) throws Exception | 使用公钥加密字节数组 |
| public static String **decryptByPublicKey** (String data, String key) throws Exception | 使用公钥解密字符串   |
| public static byte[] **decryptByPublicKey** (byte[] data, String key) throws Exception | 使用公钥解密字节数组 |
| public static String **encryptByPrivateKey** (String data, String key) throws Exception | 使用私钥加密字符串   |
| public static byte[] **encryptByPrivateKey** (byte[] data, String key) throws Exception | 使用私钥加密字节数组 |
| public static String **decryptByPrivateKey** (String data, String key) throws Exception | 使用私钥解密字符串   |
| public static byte[] **decryptByPrivateKey** (byte[] data, String key) throws Exception | 使用私钥解密字节数组 |
| public static String **sign** (String data, String privateKey) throws Exception | 创建数字签名         |
| public static String **sign** (byte[] data, String privateKey) throws Exception | 创建数字签名         |
| public static boolean **verify** (String data, String publicKey, String sign) throws Exception | 校验数字签名         |
| public static boolean **verify** (byte[] data, String publicKey, String sign) throws Exception | 校验数字签名         |

### 4、文件压缩和解压

| ZipUtils                                                     |                  |
| ------------------------------------------------------------ | ---------------- |
| public static void **zip** (String srcFileName, String destFileName) throws ZipException | 压缩单个文件     |
| public static void **zip** (Set&lt;String&gt; srcFileNames, String destFileName) throws ZipException | 压缩多个文件     |
| public static void **zip** (String srcFileName, String destFileName, String password) throws ZipException | 加密压缩单个文件 |
| public static void **zip** (Set&lt;String&gt; srcFileNames, String destFileName, String password) throws ZipException | 加密压缩多个文件 |
| public static void **zipFolder** (String folderName, String destFileName) throws ZipException | 压缩文件夹       |
| public static void **zipFolder** (String folderName, String destFileName, String password) throws ZipException | 加密压缩文件夹   |
| public static void **unZip** (String zipFileName, String targetFolder) throws ZipException | 解压缩文件       |
| public static void **unZip** (File zipFile, String targetFolder) throws ZipException | 解压缩文件       |
| public static void **unZip** (String zipFileName, String targetFolder, String password) throws ZipException | 解压缩加密的文件 |
| public static void **unZip** (File zipFile, String targetFolder, String password) throws ZipException | 解压缩加密的文件 |

此工具类基于 [zip4j](http://www.lingala.net/zip4j/) 封装，**压缩和解压的文件路径请不要包含中文，有可能出现中文文件名乱码**。

```html
<dependency>
    <groupId>net.lingala.zip4j</groupId>
    <artifactId>zip4j</artifactId>
    <version>1.3.2</version>
</dependency>
```

### 5、文本文件处理

| TxtUtils                                                     |                                                      |
| ------------------------------------------------------------ | ---------------------------------------------------- |
| public static String **readTxt** (File txtFile) throws IOException | 读取文本文件内容                                     |
| public static void **writeTxt** (String data, File txtFile) throws IOException | 将字符串内容写到文本文件中                           |
| public static List&lt;String&gt; **readTxtToList** (File txtFile) throws IOException | 将文本文件按行读取，将每一行的数据封装到 List 集合中 |
| public static void **writeTxtFromList** (List&lt;String&gt; list, File txtFile) throws IOException | 将 List 集合中的数据分行写到文本文件中               |

### 6、`JavaBean` 转换

| Converter                                                    |                     |
| ------------------------------------------------------------ | ------------------- |
| public static Object **map2Object** (Map&lt;String, Object&gt; map, Class&lt;?&gt; clazz) | 将Map转换为JavaBean |
| public static Map&lt;String, Object&gt; **object2Map** (Object obj) | 将JavaBean转换为Map |

### 7、对象克隆

| CloneUtils                                                   |              |
| ------------------------------------------------------------ | ------------ |
| public static &lt;T&gt; T **deepClone** (T t) throws IOException, ClassNotFoundException | 深度克隆对象 |

### 8、异常相关

| ExceptionUtils                                               |                    |
| ------------------------------------------------------------ | ------------------ |
| public static String **getStackTrace** (Throwable throwable) | 获取异常的堆栈信息 |

### 9、`UUID` 工具

| UUIDUtils                                             |                                |
| ----------------------------------------------------- | ------------------------------ |
| public static String **createUUID** ()                | 生成随机的UUID                 |
| public static String **create32UUID** ()              | 生成32位不带中划线的UUID       |
| public static String **createRandomString** (int len) | 生成字母和数字组合的随机字符串 |
| public static String **createRandomNumber** (int len) | 生成数字组成的随机字符串       |

### 10、日期时间处理

| DateUtils                                                  |                                                 |
| ---------------------------------------------------------- | ----------------------------------------------- |
| public static Date **getDayStart** (Date date)             | 获取某个日期当天的起始时间点                    |
| public static Date **getDayEnd** (Date date)               | 获取某个日期当天的终止时间点                    |
| public static Date **addMinutes** (Date date, int minutes) | 计算 minutes 分钟后的时间（负数表示多少分钟前） |
| public static Date **addDay** (Date date, int day)         | 计算 day 天后的时间（负数表示多少天前）         |

### 11、`Id` 生成器

| IdWorker                                      |                 |
| --------------------------------------------- | --------------- |
| public static synchronized long **nextId** () | 获取一个新的 Id |

> 该 `Id` 生成器的实现来源于 twitter 开源的 snowflake 算法。
>
> 分布式环境中，每一个部署的项目，应该指定 datacenterId 和 workerId，达到全局生成的 id 都唯一。
>
> 如：Spring 容器启动时
>
> ```java
> // datacenterId 表示机房编号，取值范围在 0-31 之间，默认值为0
> IdWorker.INSTANCE.setDatacenterId(5L);
> // workerId 表示机器编号，取值范围在 0-31 之间，默认值为0
> IdWorker.INSTANCE.setWorkerId(2L);
> ```
>
> 默认的机房编号和机器编号均为0，**非分布式环境可以不做任何配置，直接使用即可**。