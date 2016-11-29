package com.village.soa.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * MD5码工具类
 * @author lizhengyu
 *
 */
public class Md5Util {
	
	public static String md5(String str) {
		try {
			MessageDigest dist = MessageDigest.getInstance("MD5");
			byte[] data = dist.digest(str.getBytes("utf8"));
			return byte2HexStringWithoutSpace(data, 0, data.length);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String byte2HexStringWithoutSpace(byte[] b, int offset, int len) {
		char[] hex = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		if (b == null)
			return "null";

		// 检查索引范围
		int end = offset + len;
		if (end > b.length)
			end = b.length;

		StringBuffer sb = new StringBuffer();

		for (int i = offset; i < end; i++) {
			sb.append(hex[(b[i] & 0xF0) >>> 4]).append(hex[b[i] & 0xF]);
		}
		return sb.toString();
	}
	
    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
    public static String sign(String text, String key, String input_charset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
	
	public static void main(String[] args) {
		System.out.println(md5("111111"));
	}
	
}
