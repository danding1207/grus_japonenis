package com.msc.lib.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Post请求 参数 统一 生成，管理类
 * 
 * @author yang.lei
 */
public class HttpRequestParams {

	/**
	 * 攻略主题
	 *
	 * @return
	 */
	public static Map<String, String> getParamsForAdverts() {
        Map<String, String> params = new HashMap<String, String>();
		params.put("market", "ymeng");
		params.put("first_launch", "false");
		return params;
	}

	/**
	 * 游记列表
	 *
	 * @return
	 */
	public static Map<String, String> getParamsForTimelines(int page) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("page", String.valueOf(page));
		return params;
	}

	public static Map<String,String> getParamsForTimelinesFollow(String ss) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("followable_ids", ss);
		return params;
	}
}
