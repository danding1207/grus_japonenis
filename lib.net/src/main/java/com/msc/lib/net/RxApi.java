package com.msc.lib.net;

import com.msc.lib.net.bean.Adverts;
import com.msc.lib.net.bean.Destinations;
import com.msc.lib.net.bean.DestinationsSearch;
import com.msc.lib.net.bean.User;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by msc on 2016/1/28.
 */
public interface RxApi {

    /**
     * 攻略主题
     * @return
     */
    @GET(HttpURLS.adverts)
    Observable<Adverts> getAdverts();

    /**
     * 攻略列表
     * @return
     */
    @GET(HttpURLS.destinations)
    Observable<Destinations> getDestinations();

//    /**
//     * 攻略列表
//     * @return
//     */
//    @GET(HttpURLS.timelines)
//    Observable<Timelines> getTimelines(@QueryMap Map<String, String> options);
//
//    /**
//     * 攻略列表关注查询
//     * @return
//     */
//    @GET(HttpURLS.timelinesfollow)
//    Observable<TimelinesFollows> getTimelinesFollow(@QueryMap Map<String, String> options);
//
//    /**
//     * 攻略列表关注查询
//     * @return
//     */
//    @GET(HttpURLS.profiles)
//    Observable<UserProfiles> getUserProfiles(@Path("user") String user);
//
//    @GET(HttpURLS.useractivities_grouped)
//    Observable<ActivitiesGrouped> getUserActivitiesGrouped(@Path("user") String userid, @Path("groupe") String groupe);
//
    @GET(HttpURLS.destinations_search)
    Observable<DestinationsSearch> getDestinationsSearch(@Query("search_type") String search_type, @Query("q") String destinationsid);



    @GET(HttpURLS.user)
    Observable<User> getUser();


    @GET(HttpURLS.user)
    Observable<List<User>> getUsers();

//    /**
//     * 图片处理
//     * @param params
//     * @return
//     */
//    @FormUrlEncoded
//    @GET(HttpURLS.adverts)
//    Observable<Adverts> getAdverts(@FieldMap Map<String, String> params);
}
