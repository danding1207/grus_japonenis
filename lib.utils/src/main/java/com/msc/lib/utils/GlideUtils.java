package com.msc.lib.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by msc on 2016/7/20.
 */

public class GlideUtils {

    private static GlideUtils instance;
    private static Context context;

    public GlideUtils(Context context) {
        this.context = context;
    }

    /**
     * @return
     */
    public static GlideUtils getInstance(Context context) {
        if (instance == null) {
            instance = new GlideUtils(context);
        }
        return instance;
    }

    @BindingAdapter("bind:imageUrl")
    public static void imageLoader(ImageView view, String url){
        Log.e("", "imageLoader--->" + url);
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(view);
    }

    @BindingAdapter("bind:imageUri")
    public static void imageLoader(ImageView view, Uri uri){
        Log.e("", "imageLoader--->" + uri.getPath());
        Glide
                .with(context)
                .load(uri)
                .centerCrop()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(view);
    }

//    @BindingAdapter("bind:imageUrl")
//    public static void imageLoader(ImageView view, String url, int resID){
//        Glide
//                .with(context)
//                .load(url)
//                .centerCrop()
//                .dontAnimate()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(resID)
//                .crossFade()
//                .into(view);
//    }

    @BindingAdapter("bind:imageUrlCircle")
    public static void imageLoaderCircle(ImageView view, String url){
        Log.e("", "imageLoaderCircle--->" + url);
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .thumbnail(0.5f)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(view);
    }

//    @BindingAdapter("bind:imageUrlCircle")
//    public static void imageLoaderCircle(ImageView view, String url, int resID){
//        Glide
//                .with(context)
//                .load(url)
//                .centerCrop()
//                .thumbnail(0.5f)
//                .dontAnimate()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(resID)
//                .crossFade()
//                .transform(new GlideCircleTransform(context))
//                .into(view);
//    }

}
