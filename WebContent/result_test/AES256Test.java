package com.daiso.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;

public class AES256Test {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, 
	InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, 
	UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, 
	InvalidAlgorithmParameterException {
		String pw = "1234";
		String key ="%03x";
		
		String encText = AES256.encryptAES256(pw, key);
		System.out.println("AES256 : " + pw + ", 암호화 : " + encText);
		String decText = AES256.decryptAES256(encText, key);
		System.out.println("암호화 : " + encText + ", 복호화 : " + decText);
	}
}