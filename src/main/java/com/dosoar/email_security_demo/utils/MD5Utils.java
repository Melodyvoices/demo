package com.dosoar.email_security_demo.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * MD5的工具包
 */
public class MD5Utils {

	protected static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

	/**
	 * 获取文件MD5值 经过测试:消耗较小内存下,6.3G文件需要18秒左右转化时间
	 *
	 * @param file
	 * @return MD5值
	 */
	public static String getFileMd5(File file) {
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			String md5 = DigestUtils.md5Hex(is);
			return md5;
		} catch (IOException e) {
			logger.error("文件转化MD5失败, IOException:", e);
			return "";
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e2) {
				}

			}
		}
	}

	public static String getSha1(String str) {
		if (str == null) {
			return null;
		}
		return DigestUtils.sha1Hex(str);
	}

}
