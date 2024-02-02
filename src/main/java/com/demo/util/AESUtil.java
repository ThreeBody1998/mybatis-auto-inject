package com.demo.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * description AES工具类
 *
 * @author 周建泽
 * @date 2024/1/30
 */
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    /**
     * 生产环境请配置到环境变量中
     */
    private static final String AES_KEY = "wzXOw5B19KD1O2hfqcC3dA==";


    /**
     * 生成随机的 AES 密钥
     *
     * @return AES 密钥的 Base64 编码
     */
    public static String generateRandomKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128); // 128-bit key size for AES
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * 使用 AES 加密文本
     *
     * @param plaintext 待加密的文本
     * @return 加密后的 Base64 编码字符串
     */
    public static String encrypt(String plaintext) {
        Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(AES_KEY), ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用 AES 解密文本
     *
     * @param ciphertext 待解密的 Base64 编码字符串
     * @return 解密后的原始文本
     */
    public static String decrypt(String ciphertext) {
        Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(AES_KEY), ALGORITHM);
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
