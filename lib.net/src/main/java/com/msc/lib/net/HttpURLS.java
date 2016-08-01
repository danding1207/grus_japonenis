package com.msc.lib.net;

/**
 *  url ͳһ����
 * @author yang.lei
 *
 */
public class HttpURLS {
	
	/** ip  */
	public static final String ip = "http://q.chanyouji.com";

	/** 攻略主题 */
	public static final String adverts = ip+"/api/v1/adverts.json?market=ymeng&first_launch=false";
	/** 攻略列表 */
	public static final String destinations = ip+"/api/v2/destinations.json";
	/** 游记列表 */
	public static final String timelines = ip+"/api/v1/timelines.json";
	/** 游记列表关注查询 */
	public static final String timelinesfollow = ip+"/api/v1/follows.json";

	/** 目的地搜索 */
	public static final String destinations_search = ip+"/api/v1/search.json";

	/** 用户信息查询 */
	public static final String profiles = ip+"/api/v1/users/{user}/profiles.json";
	/** 用户游记查询 */
	public static final String useractivities_page = ip+"/api/v1/users/{user}/user_activities.json?page={page}";
	/** 用户游记查询 */
	public static final String useractivities_grouped = ip+"/api/v1/users/{user}/user_activities.json?grouped={groupe}";

	/** 用户信息查询 */
	public static final String user = ip+"/api/v1/i/profiles.json";

}
