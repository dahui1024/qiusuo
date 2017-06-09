package com.bbcow.qiusuo.commons.algorithm;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5 {
	private final static Logger logger = LoggerFactory.getLogger(MD5.class);

	public static String digest(String src) {
		try {
			byte[] btInput = src.getBytes("UTF-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	public static String digest_16bit(String src) {
		String digest_32 = digest(src);
		if (digest_32 != null) {
			return digest_32.substring(8, 24);
		} else {
			return null;
		}
	}
	public static String digest(byte[] bytes) {
		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(bytes);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
}
