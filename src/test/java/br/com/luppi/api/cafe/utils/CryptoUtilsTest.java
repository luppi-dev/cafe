package br.com.luppi.api.cafe.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CryptoUtilsTest {

    private static final String PASSWORD_1 = "123";
    private static final byte[] SALT_1 = CryptoUtils.generateSalt();
    private static final String PASSWORD_2 = "321";
    private static final byte[] SALT_2 = CryptoUtils.generateSalt();

    @Test
    public void givenSamePasswordAndSalt_thenHashIsCorrect() {
        byte[] hash = CryptoUtils.hashWithBcrypt(PASSWORD_1, SALT_1);
        Assertions.assertTrue(CryptoUtils.verify(PASSWORD_1, hash, SALT_1));
    }

    @Test
    public void givenDifferentPassword_thenHashIsIncorrect() {
        byte[] hash = CryptoUtils.hashWithBcrypt(PASSWORD_1, SALT_1);
        Assertions.assertFalse(CryptoUtils.verify(PASSWORD_2, hash, SALT_1));
    }

    @Test
    public void givenDifferentSalt_thenHashIsIncorrect() {
       byte[] hash = CryptoUtils.hashWithBcrypt(PASSWORD_1, SALT_1);
       Assertions.assertFalse(CryptoUtils.verify(PASSWORD_1, hash, SALT_2));
    }
}
