package com.msc.lib.net;

import android.content.Context;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by JianTao on 16/1/20.
 * Copyright © 2015 impetusconsulting. All rights reserved
 */
public class AppService {
    private static AppService instance = new AppService();
    private static RxApi rxApi;
    private static ExecutorService sSingleThreadExecutor;
    private static Gson sGson;

    private Map<Integer, CompositeSubscription> compositeSubscriptionMap;

    public AppService() {
    }

    public AppService initService(final Context context) {
        compositeSubscriptionMap = new HashMap<>();
        sGson=new Gson();
        sSingleThreadExecutor = Executors.newSingleThreadExecutor();
        sSingleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                rxApi = RxApiFactory.getRxApi(context);
            }
        });
        return instance;
    }

    public static Gson getsGson() {
        return sGson;
    }

    public void addCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap.get(taskId) == null) {
            compositeSubscription = new CompositeSubscription();
            compositeSubscriptionMap.put(taskId, compositeSubscription);
        }
    }

    public void removeCompositeSub(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap != null && compositeSubscriptionMap.get(taskId) != null) {
            compositeSubscription = compositeSubscriptionMap.get(taskId);
            compositeSubscription.unsubscribe();
            compositeSubscriptionMap.remove(taskId);
        }
    }

    public CompositeSubscription getCompositeSubscription(int taskId) {
        CompositeSubscription compositeSubscription;
        if (compositeSubscriptionMap.get(taskId) == null) {
            compositeSubscription = new CompositeSubscription();
            compositeSubscriptionMap.put(taskId, compositeSubscription);
        } else {
            compositeSubscription = compositeSubscriptionMap.get(taskId);
        }
        return compositeSubscription;
    }

    public Map<Integer, CompositeSubscription> getCompositeSubscriptionMap() {
        return compositeSubscriptionMap;
    }

    public static AppService getInstance() {
        return instance;
    }

    public static RxApi getRxApi() {
        return rxApi;
    }

    public static ExecutorService getsSingleThreadExecutor() {
        return sSingleThreadExecutor;
    }

    public void getAdverts(Context context,int taskId) {
        getCompositeSubscription(taskId).add(RxHttp.getAdverts(context));
    }

    public void getDestinations(Context context,int taskId) {
        getCompositeSubscription(taskId).add(RxHttp.getDestinations(context));
    }

    public void getDestinationsSearch(Context context,int taskId,String type, String id) {
        getCompositeSubscription(taskId).add(RxHttp.getDestinationsSearch(context, type, id));
    }

    public void getUser(Context context,int taskId) {
        getCompositeSubscription(taskId).add(RxHttp.getUser(context));
    }

    public void getUnread(Context context,int taskId) {
        getCompositeSubscription(taskId).add(RxHttp.getUnread(context));
    }

    public void getDestinationsNearby(Context context,int taskId, String lat, String lng) {
        getCompositeSubscription(taskId).add(RxHttp.getDestinationsNearby(context, lat, lng));
    }


//
//    public void getTimelines(Context context,int taskId, int page, boolean isRefresh) {
//        getCompositeSubscription(taskId).add(RxHttp.getTimelines(context, page, isRefresh));
//    }
//
//
//    public void getTimelinesFollow(Context context, int taskId, String ss) {
//        getCompositeSubscription(taskId).add(RxHttp.getTimelinesFollow(context, ss));
//    }
//
//    public void getUserProfiles(Context context, int taskId, String userid) {
//        getCompositeSubscription(taskId).add(RxHttp.getUserProfiles(context, userid));
//    }
//
//    public void getUserActivitiesGrouped(Context context, int taskId, String userid, String groupe) {
//        getCompositeSubscription(taskId).add(RxHttp.getUserActivitiesGrouped(context, userid, groupe));
//    }
//
//    public void getUserActivitiesPage(Context context, int taskId, String userid, String page) {
//        getCompositeSubscription(taskId).add(RxHttp.getUserActivitiesPage(context, userid, page));
//    }
}