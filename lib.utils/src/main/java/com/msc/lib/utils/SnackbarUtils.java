package com.msc.lib.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by msc on 2016/1/29.
 */
public class SnackbarUtils {

    /**
     * @param context
     * @param msg
     * @param action
     * @param duration
     * @param listener
     */
    public static void toast(@NonNull Activity context,@NonNull String msg, String action, @NonNull int duration, View.OnClickListener listener) {
        Snackbar snackbar = Snackbar.make(context.findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setBackgroundColor(0x99000000);
        ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(context, android.R.color.white));
        snackbar .setAction(action, listener)
                .setDuration(duration).show();
    }

    /**
     * @param context
     * @param msg
     * @param action
     * @param duration
     * @param listener
     */
    public static void toast(@NonNull ViewGroup context, @NonNull String msg, String action, @NonNull int duration, View.OnClickListener listener) {
        Snackbar snackbar = Snackbar.make(context, msg, Snackbar.LENGTH_SHORT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setBackgroundColor(0x99000000);
        ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(context.getContext(), android.R.color.white));
        snackbar .setAction(action, listener)
                .setDuration(duration).show();
    }

    /**
     * @param context
     * @param msg
     * @param duration
     * @param listener
     */
    public static void toast(@NonNull Activity context,@NonNull String msg,@NonNull int duration, View.OnClickListener listener) {
        toast(context, msg, "", duration, listener);
    }

    /**
     * @param context
     * @param msg
     * @param duration
     */
    public static void toast(@NonNull Activity context, @NonNull String msg, @NonNull int duration) {
        toast(context,msg, duration, null);
    }

    /**
     * @param context
     * @param msg
     * @param duration
     * @param listener
     */
    public static void toast(@NonNull ViewGroup context,@NonNull String msg,@NonNull int duration, View.OnClickListener listener) {
        toast(context, msg, "", duration, listener);
    }

    /**
     * @param context
     * @param msg
     * @param duration
     */
    public static void toast(@NonNull ViewGroup context, @NonNull String msg, @NonNull int duration) {
        toast(context,msg, duration, null);
    }

}
