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
| public static <T> T **fromJson** (String text, Class<T> clazz) | 将字符串反序列化为 Java 对象                           |

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

