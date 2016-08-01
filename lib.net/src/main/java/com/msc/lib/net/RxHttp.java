package com.msc.lib.net;

import android.content.Context;

import com.hwangjr.rxbus.RxBus;
import com.msc.lib.net.bean.Adverts;
import com.msc.lib.net.bean.Destinations;
import com.msc.lib.net.bean.DestinationsSearch;
import com.msc.lib.net.bean.User;
import com.msc.lib.net.event.AdvertsEvent;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.DestinationsEvent;
import com.msc.lib.net.event.DestinationsSearchEvent;
import com.msc.lib.net.event.UserEvent;
import com.orhanobut.logger.Logger;
//import com.msc.inspiration.lib.bean.Event.ActivitiesGroupedEvent;
//import com.msc.inspiration.lib.bean.Event.ActivitiesPageEvent;
//import com.msc.inspiration.lib.bean.Event.AdvertsEvent;
//import com.msc.inspiration.lib.bean.Event.Constant;
//import com.msc.inspiration.lib.bean.Event.DestinationsEvent;
//import com.msc.inspiration.lib.bean.Event.TimelinesEvent;
//import com.msc.inspiration.lib.bean.Event.TimelinesFollowsEvent;
//import com.msc.inspiration.lib.bean.Event.UserProfilesEvent;
//import com.msc.inspiration.lib.bean.bean.ActivitiesGrouped;
//import com.msc.inspiration.lib.bean.bean.ActivitiesPage;
//import com.msc.inspiration.lib.bean.bean.Adverts;
//import com.msc.inspiration.lib.bean.bean.Destinations;
//import com.msc.inspiration.lib.bean.bean.Timelines;
//import com.msc.inspiration.lib.bean.bean.TimelinesFollows;
//import com.msc.inspiration.lib.bean.bean.UserProfiles;
//import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by msc on 2016/1/28.
 */
public class RxHttp {

    private static final String TAG = RxHttp.class.getName();
    private static final boolean DEBUG = true;

    public static Subscription getAdverts(Context context) {
        Subscription subscription = RxApiFactory.getRxApi(context).getAdverts()
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<Adverts>() {
                    @Override
                    public void call(Adverts result) {

                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Adverts>() {
                    @Override
                    public void call(Adverts result) {
                        Logger.d(result.toString());
                        AdvertsEvent newsEvent = new AdvertsEvent(result, Constant.GetResultWay.UPDATA, null);
                        if (result == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.get().post(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.toString());
                        AdvertsEvent newsEvent = new AdvertsEvent(new Adverts(), Constant.GetResultWay.UPDATA, throwable);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.get().post(newsEvent);
                    }
                });
        return subscription;
    }

    public static Subscription getDestinations(Context context) {
        Subscription subscription = RxApiFactory.getRxApi(context).getDestinations()
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<Destinations>() {
                    @Override
                    public void call(Destinations result) {

                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Destinations>() {
                    @Override
                    public void call(Destinations result) {
                        Logger.d(result.toString());
                        DestinationsEvent newsEvent = new DestinationsEvent(result, Constant.GetResultWay.UPDATA, null);
                        if (result == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.get().post(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.toString());
                        DestinationsEvent newsEvent = new DestinationsEvent(new Destinations(), Constant.GetResultWay.UPDATA, throwable);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.get().post(newsEvent);
                    }
                });
        return subscription;
    }


    public static Subscription getDestinationsSearch(Context context,String type, String id) {
        Subscription subscription = RxApiFactory.getRxApi(context).getDestinationsSearch(type, id)
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<DestinationsSearch>() {
                    @Override
                    public void call(DestinationsSearch result) {

                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<DestinationsSearch>() {
                    @Override
                    public void call(DestinationsSearch result) {
                        Logger.d(result.toString());
                        DestinationsSearchEvent newsEvent = new DestinationsSearchEvent(result, Constant.GetResultWay.UPDATA, null);
                        if (result == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.get().post(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.toString());
                        DestinationsSearchEvent newsEvent = new DestinationsSearchEvent(new DestinationsSearch(), Constant.GetResultWay.UPDATA, throwable);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.get().post(newsEvent);
                    }
                });
        return subscription;
    }

    public static Subscription getUser(Context context) {
        Subscription subscription = RxApiFactory.getRxApi(context).getUser()
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<User>() {
                    @Override
                    public void call(User result) {

                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<User>() {
                    @Override
                    public void call(User result) {
                        Logger.d(result.toString());
                        UserEvent newsEvent = new UserEvent(result, Constant.GetResultWay.UPDATA, null);
                        if (result == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.get().post(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.toString());
                        UserEvent newsEvent = new UserEvent(new User(), Constant.GetResultWay.UPDATA, throwable);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.get().post(newsEvent);
                    }
                });
        return subscription;
    }

    public static Subscription getUsers(Context context) {
        Subscription subscription = RxApiFactory.getRxApi(context).getUsers()
                .subscribeOn(Schedulers.newThread()).doOnNext(new Action1<List<User>>() {
                    @Override
                    public void call(List<User> result) {

                    }
                })
                .flatMap(new Func1<List<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(List<User> users) {
                        return Observable.from(users);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<User>() {
                    @Override
                    public void call(User result) {
                        Logger.d(result.toString());
                        UserEvent newsEvent = new UserEvent(result, Constant.GetResultWay.UPDATA, null);
                        if (result == null) {
                            newsEvent.setmEventResult(Constant.Result.FAIL);
                        } else {
                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
                        }
                        RxBus.get().post(newsEvent);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable.toString());
                        UserEvent newsEvent = new UserEvent(new User(), Constant.GetResultWay.UPDATA, throwable);
                        newsEvent.setmEventResult(Constant.Result.FAIL);
                        RxBus.get().post(newsEvent);
                    }
                });
        return subscription;
    }

//
//    public static Subscription getTimelines(Context context, int page, final boolean isRefresh) {
//
//        Map<String, String> params = HttpRequestParams.getParamsForTimelines(page);
//
//        if (DEBUG) {
//            Logger.d(params.toString());
//        }
//
//        Subscription subscription = RxApiFactory.getRxApi(context).getTimelines(params)
//                .subscribeOn(Schedulers.newThread())
//                .debounce(1000, TimeUnit.MILLISECONDS, Schedulers.io())
//                .doOnNext(new Action1<Timelines>() {
//                    @Override
//                    public void call(Timelines result) {
//
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Timelines>() {
//                    @Override
//                    public void call(Timelines result) {
//                        Logger.d(result.toString());
//                        TimelinesEvent newsEvent;
//                        if (isRefresh)
//                            newsEvent = new TimelinesEvent(result, Constant.GetResultWay.UPDATA, null);
//                        else
//                            newsEvent = new TimelinesEvent(result, Constant.GetResultWay.LOADMORE, null);
//                        if (result == null) {
//                            newsEvent.setmEventResult(Constant.Result.FAIL);
//                        } else {
//                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
//                        }
//                        RxBus.get().post(newsEvent);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.e(throwable.toString());
//                        TimelinesEvent newsEvent;
//                        if (isRefresh)
//                            newsEvent = new TimelinesEvent(new Timelines(), Constant.GetResultWay.UPDATA, throwable);
//                        else
//                            newsEvent = new TimelinesEvent(new Timelines(), Constant.GetResultWay.LOADMORE, throwable);
//                        newsEvent.setmEventResult(Constant.Result.FAIL);
//                        RxBus.get().post(newsEvent);
//                    }
//                });
//        return subscription;
//    }
//
//
//    public static Subscription getTimelinesFollow(Context context, String ss) {
//        Map<String, String> params = HttpRequestParams.getParamsForTimelinesFollow(ss);
//
//        if (DEBUG) {
//            Logger.d(params.toString());
//        }
//
//        Subscription subscription = RxApiFactory.getRxApi(context).getTimelinesFollow(params)
//                .subscribeOn(Schedulers.newThread())
//                .debounce(1000, TimeUnit.MILLISECONDS, Schedulers.io())
//                .doOnNext(new Action1<TimelinesFollows>() {
//                    @Override
//                    public void call(TimelinesFollows result) {
//
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<TimelinesFollows>() {
//                    @Override
//                    public void call(TimelinesFollows result) {
//                        Logger.d(result.toString());
//                        TimelinesFollowsEvent newsEvent = new TimelinesFollowsEvent(result, Constant.GetResultWay.UPDATA, null);
//                        if (result == null) {
//                            newsEvent.setmEventResult(Constant.Result.FAIL);
//                        } else {
//                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
//                        }
//                        RxBus.get().post(newsEvent);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.e(throwable.toString());
//                        TimelinesFollowsEvent newsEvent = new TimelinesFollowsEvent(new TimelinesFollows(), Constant.GetResultWay.UPDATA, throwable);
//                        newsEvent.setmEventResult(Constant.Result.FAIL);
//                        RxBus.get().post(newsEvent);
//                    }
//                });
//        return subscription;
//    }
//
//    public static Subscription getUserProfiles(Context context, String userid) {
//        Subscription subscription = RxApiFactory.getRxApi(context).getUserProfiles(userid)
//                .subscribeOn(Schedulers.newThread())
//                .debounce(1000, TimeUnit.MILLISECONDS, Schedulers.io())
//                .doOnNext(new Action1<UserProfiles>() {
//                    @Override
//                    public void call(UserProfiles result) {
//
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<UserProfiles>() {
//                    @Override
//                    public void call(UserProfiles result) {
//                        Logger.d(result.toString());
//                        UserProfilesEvent newsEvent = new UserProfilesEvent(result, Constant.GetResultWay.UPDATA, null);
//                        if (result == null) {
//                            newsEvent.setmEventResult(Constant.Result.FAIL);
//                        } else {
//                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
//                        }
//                        RxBus.get().post(newsEvent);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.e(throwable.toString());
//                        UserProfilesEvent newsEvent = new UserProfilesEvent(new UserProfiles(), Constant.GetResultWay.UPDATA, throwable);
//                        newsEvent.setmEventResult(Constant.Result.FAIL);
//                        RxBus.get().post(newsEvent);
//                    }
//                });
//        return subscription;
//    }
//
//    public static Subscription getUserActivitiesGrouped(Context context, String userid, String groupe) {
//        Subscription subscription = RxApiFactory.getRxApi(context).getUserActivitiesGrouped(userid, groupe)
//                .subscribeOn(Schedulers.newThread())
//                .debounce(1000, TimeUnit.MILLISECONDS, Schedulers.io())
//                .doOnNext(new Action1<ActivitiesGrouped>() {
//                    @Override
//                    public void call(ActivitiesGrouped result) {
//
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ActivitiesGrouped>() {
//                    @Override
//                    public void call(ActivitiesGrouped result) {
//                        Logger.d(result.toString());
//                        ActivitiesGroupedEvent newsEvent = new ActivitiesGroupedEvent(result, Constant.GetResultWay.UPDATA, null);
//                        if (result == null) {
//                            newsEvent.setmEventResult(Constant.Result.FAIL);
//                        } else {
//                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
//                        }
//                        RxBus.get().post(newsEvent);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.e(throwable.toString());
//                        ActivitiesGroupedEvent newsEvent = new ActivitiesGroupedEvent(new ActivitiesGrouped(), Constant.GetResultWay.UPDATA, throwable);
//                        newsEvent.setmEventResult(Constant.Result.FAIL);
//                        RxBus.get().post(newsEvent);
//                    }
//                });
//        return subscription;
//    }
//
//    public static Subscription getUserActivitiesPage(Context context, String userid, String page) {
//        Subscription subscription = RxApiFactory.getRxApi(context).getUserActivitiesPage(userid, page)
//                .subscribeOn(Schedulers.newThread())
//                .debounce(1000, TimeUnit.MILLISECONDS, Schedulers.io())
//                .doOnNext(new Action1<ActivitiesPage>() {
//                    @Override
//                    public void call(ActivitiesPage result) {
//
//                    }
//                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ActivitiesPage>() {
//                    @Override
//                    public void call(ActivitiesPage result) {
//                        Logger.d(result.toString());
//                        ActivitiesPageEvent newsEvent = new ActivitiesPageEvent(result, Constant.GetResultWay.UPDATA, null);
//                        if (result == null) {
//                            newsEvent.setmEventResult(Constant.Result.FAIL);
//                        } else {
//                            newsEvent.setmEventResult(Constant.Result.SUCCESSS);
//                        }
//                        RxBus.get().post(newsEvent);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Logger.e(throwable.toString());
//                        ActivitiesPageEvent newsEvent = new ActivitiesPageEvent(new ActivitiesPage(), Constant.GetResultWay.UPDATA, throwable);
//                        newsEvent.setmEventResult(Constant.Result.FAIL);
//                        RxBus.get().post(newsEvent);
//                    }
//                });
//        return subscription;
//    }
}
