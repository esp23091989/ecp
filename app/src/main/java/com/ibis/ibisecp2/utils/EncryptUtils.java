package com.ibis.ibisecp2.utils;

import android.util.Base64;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.crypto.Cipher;

/**
 * Created by danila on 08.06.16.
 */
public class EncryptUtils {

    private SharedPreferencesUtils preferencesUtils;

    public EncryptUtils(SharedPreferencesUtils preferencesUtils) {
        this.preferencesUtils = preferencesUtils;
    }

    private byte[] encrypt(byte[] b1) throws Exception {
//
//        String test = "cd:cc:10:76:42:f5:f0:e4:bd:52:9c:d4:94" +
//                ":98:92:89:cd:e6:4a:62:f0:fe:d0:f6:0a:e8:ff:aa:74:8d:f1:7e:46:f5:a8:41" +
//                ":14:0d:d2:2b:a7:f1:78:93: 4b:da:74:35:eb:4b:7d:29:48:12:4b:87:4a:20:02:" +
//                "ad:b3:dd:67:40:65:57:68:e7:c5:87:d1:69:67:c6:c8:bd:ab:54:8a:ef:93:0f:bb:f2:" +
//                "d7:a5:a3:8d:e7:ef:0b:38:59:0c:9a:d2:84:89:7d:3b:16:a0:74:ac:" +
//                "7a:a3:5f:d9:78:8a:8a:1e:6e:d7:45:62:b7:0a:10:" +
//                "f5:ba:f9:12:b4:58:2d:07:c1";
//
//        String te = test.replaceAll(":","");
//        String trw = te.toUpperCase();
//        Log.e("sdsd", trw);

        BigInteger modulus = new BigInteger(
                "CDCC107642F5F0E4BD529CD494989289CDE64A62F0FED0F60AE8" +
                        "FFAA748DF17E46F5A841140DD22BA7F178934BDA7435EB4B7D294" +
                        "8124B874A2002ADB3DD6740655768E7C587D16967C6C8BDAB548AEF930FBB" +
                        "F2D7A5A38DE7EF0B38590C9AD284897D3B16A074AC7AA35FD9788A8A1E6ED7" +
                        "4562B70A10F5BAF912B4582D07C1",
                16);
        BigInteger pubExp = new BigInteger("010001", 16);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, pubExp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(b1);
    }

    public String encryptLogin(String login, String password, String type) {
        byte[] b2 = new byte[0];
        try {
//            "+7(928)7612780" + " " + "anna19031984" + " " + "phone" + " " + "29.11.2016 12:56:31"
            b2 = encrypt((login + " " + password + " " + type + " " + getTime())
                    .getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(b2, Base64.CRLF);
    }

    public String getToken() {
        byte[] token = new byte[0];
        try {
            token = encrypt((preferencesUtils.getSnils() + " " + getTime() + " "
                    + String.valueOf("0") + " " + String.valueOf("0")).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(token, Base64.CRLF);
    }


    public String getTestToken() {
        byte[] token = new byte[0];
        try {
            token = encrypt(("15688742829" + " " + getTime() + " "
                    + String.valueOf("0") + " " + String.valueOf("0")).getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(token, Base64.CRLF);
    }

    private String getTime() {
        final Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        return simpleDateFormat.format(calendar.getTime());
    }

}