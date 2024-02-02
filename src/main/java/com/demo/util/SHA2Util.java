package com.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * description  sha2工具类
 * @author 周建泽
 * @date 2024/1/30
 */
public class SHA2Util {
    /**
     * 计算字符串的 MD5 散列值
     *
     * @param input 输入字符串
     * @return MD5 散列值的十六进制表示
     */
    /**
     * 计算字符串的 SHA-256 散列值
     *
     * @param input 输入字符串
     * @return SHA-256 散列值的十六进制表示
     */
    public static String calculateSHA256(String input) {
        try {
            // 获取 SHA-256 摘要算法实例
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // 将输入字符串转换为字节数组，并进行摘要计算
            byte[] digest = md.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
