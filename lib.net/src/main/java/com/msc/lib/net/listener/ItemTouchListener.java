package com.msc.lib.net.listener;

/**
 * Created by sks on 2015/8/27.
 */
public interface ItemTouchListener {
	void onItemMove(int fromPosition, int toPosition);
	void onItemDismiss(int position);
}
