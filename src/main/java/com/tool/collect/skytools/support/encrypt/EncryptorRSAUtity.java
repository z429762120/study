package com.tool.collect.skytools.support.encrypt;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/6/11 下午7:12
 **/
@UtilityClass
public class EncryptorRSAUtity {
    private String pk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCeM44ttfRvq2VkGg+pngzxZDMQ0rAVr8KSlyVLlLw2GPqSwH9D+L+BXUUh3S5OWC9ESjgkMQuyiolpU4A9xStT7G34Yta4rXD0ygoi/JxRcIykaEg0suKjrTKccSW4koLn//virFXkwx7PEop0od91H+8aGVvO6oNKpnKytPlYywIDAQAB";
    private String sk = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ4zji219G+rZWQaD6meDPFkMxDSsBWvwpKXJUuUvDYY+pLAf0P4v4FdRSHdLk5YL0RKOCQxC7KKiWlTgD3FK1Psbfhi1ritcPTKCiL8nFFwjKRoSDSy4qOtMpxxJbiSguf/++KsVeTDHs8SinSh33Uf7xoZW87qg0qmcrK0+VjLAgMBAAECgYB3fKMHXWWYrlCvMYvg5ZILBE4Zh7gdORnxlB1EH7uj9GvVSXUWBpvF/odHk4H1BF/26UPL+gtGt6IfnkS+4tvcnDsmTUJuMzwqi4eGdTA8zbVRPy24fv7kxMpeUlFE6uv11DGzinWfEev75bekgTE0uvo1vulABlUc8nK8UD5aaQJBAOyU9rjphE91kf/Wulf48BDZBlOdXLVRpqlF+EqAV504wXkDn8Pp2tjiI81PexCbqOTYSTUgXpOewWLeqcSL4E8CQQCrL6r/WIR5pjpSaSTg0wNMdjpsHiv+IMlxjP+F7biRXZJtF6fbGTwxUCRRhrMU36lPSmK51rpwMp5wjyoPQ4TFAkBVXBIA+dBRUxxQcMtfPmRvz74moRp4GXPGk4ZYayIxie7UmOgmKdRaeI1uYIUIowE3QIp5bqpxHNCtuaULU2SlAkB9MBv2Jo6iw+yMzfW5MLeN2Dw7SwlTDDklAD7xe3ppXCuz+gO4F8lMKtaUhFQ8ZKBVqwlt7Fllqa7yk8/nX7IdAkAHo0U2ySfg1soahUwJLn1Ot2VIJ+FvPzzmDYmEWa/nuiGyk43Bjyqc1sYogZVXRc53WRfCv60wJtEuYDaHou8Y";

    /**
     * RSA加密对明文的长度有所限制，规定需加密的明文最大长度=密钥长度-11（单位是字节，即byte），所以在加密和解密的过程中需要分块进行。
     * 而密钥默认是1024位，即1024位/8位-11=128-11=117字节。所以默认加密前的明文最大长度117字节，解密密文最大长度为128字。
     * 那么为啥两者相差11字节呢？是因为RSA加密使用到了填充模式（padding），即内容不足117字节时会自动填满，用到填充模式自然会占用一定的字节，而且这部分字节也是参与加密的
     *
     * RSA最晓加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;


    /**
     * 获取密钥对
     *
     * @return
     * @throws Exception
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA_ALGORITHM.RSA);
        generator.initialize(1024);
        return generator.generateKeyPair();
    }

    /**
     * 获取私钥
     *
     * @param privateKey privateKey 私钥字符串
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM.RSA);
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取公钥
     *
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM.RSA);
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * RSA 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥字符串
     * @return
     */
    public static String encrypt(String data, String publicKey) throws Exception {
        return encrypt(data, getPublicKey(publicKey));
    }


    /**
     * RSA 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return
     */
    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM.RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.getBytes().length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        // 获取加密内容使用base64进行编码,并以UTF-8为标准转化成字符串
        // 加密后的字符串
        return Base64.encodeBase64String(encryptedData);
    }

    public static String decrypt(String data, String privateKey) throws Exception {
        return decrypt(data, getPrivateKey(privateKey));
    }

    /**
     * RSA 私钥解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return
     */
    public static String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM.RSA);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dataBytes = Base64.decodeBase64(data);
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        // 解密后的内容
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    /**
     * 签名
     *
     * @param data
     * @param privateKey 私钥字符串
     * @param algorithm  加密算法
     * @return
     * @throws Exception
     */
    public static String sign(String data, String privateKey, String algorithm) throws Exception {
        return sign(data, getPrivateKey(privateKey), algorithm);
    }

    /**
     * 签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @param algorithm  加密算法
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey, String algorithm) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 验签
     *
     * @param srcData   原始字符串
     * @param publicKey 公钥字符串
     * @param sign      签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, String publicKey, String algorithm, String sign) throws Exception {
        return verify(srcData, getPublicKey(publicKey), algorithm, sign);
    }

    /**
     * 验签
     *
     * @param srcData   原始字符串
     * @param publicKey 公钥
     * @param sign      签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String algorithm, String sign) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(publicKey);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    /**
     * RSA加密算法
     */
    public enum RSA_ALGORITHM {
        /**
         * RSA加密算法
         */
        MD2withRSA( "MD2withRSA"),
        MD5withRSA( "MD5withRSA"),
        SHA1withRSA( "SHA1withRSA"),
        SHA256withRSA("SHA256withRSA");
        private String algorithm;
        public static final String RSA = "RSA";

        RSA_ALGORITHM(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getAlgorithm() {
            return algorithm;
        }
    }

    public static void main(String[] args) {
        try {
            PrivateKey privateKey = getPrivateKey(sk);
            PublicKey publicKey = getPublicKey(pk);

            String data = "我是一个粉刷匠";
            String sign = sign(data, privateKey, RSA_ALGORITHM.SHA1withRSA.algorithm);
            System.out.println(sign);

            System.out.println(verify(data, publicKey, RSA_ALGORITHM.SHA1withRSA.algorithm, sign));
            System.out.println(verify(data, pk, RSA_ALGORITHM.SHA1withRSA.algorithm, sign));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
