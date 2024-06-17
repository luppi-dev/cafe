package br.com.luppi.api.cafe.utils;

import org.bouncycastle.crypto.generators.BCrypt;

import java.security.SecureRandom;
import java.util.Arrays;

public class CryptoUtils {

    private static final int NUM_OF_ITERATIONS = 10;


    public static byte[] generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static byte[] hashWithBcrypt(String content, byte[] salt) {
        byte[] contentBytes = BCrypt.passwordToByteArray(content.toCharArray());
        return BCrypt.generate(contentBytes, salt, NUM_OF_ITERATIONS);
    }

    public static boolean verify(String strToVerify, byte[] hash, byte[] salt) {
        return Arrays.equals(hashToVerify, hashWithBcrypt(content,salt));
    }
}
