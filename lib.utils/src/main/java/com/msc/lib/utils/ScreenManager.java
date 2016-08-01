package com.msc.lib.utils;

import java.util.Stack;

import android.app.Activity;

public class ScreenManager {

	private static Stack<Activity> activityStack;
	private static ScreenManager instance;

	public ScreenManager() {
	}

	/**
	 * ����ģʽ
	 * 
	 * @return
	 */
	public static ScreenManager getScreenManager() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	/**
	 * ջ��Activity��ջ����finish
	 * 
	 * @return
	 */
	public void popActivity() {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		Activity activity = activityStack.lastElement();
		if (activity != null) {
//			Log.i("ScreenManager", "popActivity--->" + activity.getClass());
			activity.finish();
			activity = null;
		}
	}

	/**
	 * ָ��Activity��ջ����finish
	 * 
	 * @return
	 */
	public void popActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		if (activity != null) {
//			Log.i("ScreenManager", "popActivity--->" + activity.getClass());
			activity.finish();
			activityStack.remove(activity);
//			Log.i("ScreenManager",
//					"activityStack.size--->" + activityStack.size());
			activity = null;
		}
	}

	/**
	 * ��õ�ǰջ��Activity�����򷵻�null
	 * 
	 * @return
	 */
	public boolean isCurrentActivity(Class cls) {
		if (!activityStack.isEmpty()) {
			Activity activity = activityStack.lastElement();
//			Log.i("ScreenManager",
//					"activityStack.size--->" + activityStack.size());
//			Log.i("ScreenManager", "currentActivity--->" + activity.getClass());
			if (activity.getClass().equals(cls)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否要强制跳转到登陆页面
	 */
	public boolean isWelcomeActivity() {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
			return true;
		}
		return false;
	}

	/**
	 * ��õ�ǰջ��Activity�����򷵻�null
	 * 
	 * @return
	 */
	public boolean isContainActivity(Class cls) {
		if (!activityStack.isEmpty()) {
			for (Activity activity : activityStack) {
				if (activity.getClass().equals(cls)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ��õ�ǰջ��Activity�����򷵻�null
	 * 
	 * @return
	 */
	public Activity currentActivity() {
		if (!activityStack.isEmpty()) {
			Activity activity = activityStack.lastElement();
//			Log.i("ScreenManager",
//					"activityStack.size--->" + activityStack.size());
//			Log.i("ScreenManager", "currentActivity--->" + activity.getClass());
//			DataBaiduPush.setTopActivity((BaseActivity)activity);
			return activity;
		}
		return null;
	}

	/**
	 * ָ��Activity��ջ
	 * 
	 * @return
	 */
	public void pushActivity(Activity activity) {
//		Log.i("ScreenManager", "pushActivity--->" + activity.getClass());
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
//		Log.i("ScreenManager", "activityStack.size--->" + activityStack.size());
	}

	/**
	 * ��ջ����ʼ��ջActivity��ֱ��ָ��Activity
	 * 
	 * @return
	 */
	public void popAllActivityExceptOne(Class cls) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
//			Log.i("ScreenManager",
//					"popAllActivityExceptOne--->" + activity.getClass());
			if (activity.getClass().equals(cls)) {
				break;
			}
			popActivity(activity);
		}
	}

	/**
	 * ��ջ����ʼ��ջActivity��ֱ��ָ��Activity��������
	 * 
	 * @return
	 */
	public void popAllActivityExceptOneInclude(Class cls) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
//			Log.i("ScreenManager",
//					"popAllActivityExceptOne--->" + activity.getClass());
			popActivity(activity);
			if (activity.getClass().equals(cls)) {
				break;
			}
		}
	}

	/**
	 * ��ջ����ʼ��ջ����Activity
	 * 
	 * @return
	 */
	public void popAllActivity() {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
//			Log.i("ScreenManager",
//					"popAllActivityExceptOne--->" + activity.getClass());
			popActivity(activity);
		}
	}

	/**
	 * ջ��Activity��ջ����finish
	 * 
	 * @return
	 */
	public void popActivity(Class cls) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		if (activityStack.isEmpty()) {
			return;
		}
		Activity activity = activityStack.lastElement();
		if (activity != null) {
			if (activity.getClass().equals(cls)) {
				activity.finish();
				activity = null;
			}
		}
	}
}
