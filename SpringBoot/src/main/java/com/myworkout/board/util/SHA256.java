package com.myworkout.board.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public String getHash(String pw) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(pw.getBytes());
		return byteToHex(md.digest());
	}

	private String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes)
			builder.append(String.format("%02x", b));
		return builder.toString();
	}
}
