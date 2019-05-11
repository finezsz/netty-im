package com.netty.im.core.util;

import java.util.UUID;

public class StringUtils {

	/**
	 * 生产随机id
	 * 
	 * @return
	 */
	public static String uniqueStr() {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}

}
