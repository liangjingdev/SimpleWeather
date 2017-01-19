package activitytest.example.com.simpleweather.impl;

import activitytest.example.com.simpleweather.data.WeatherDataBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 2017/1/18.
 * 描述：天气接口
 */

public interface WeatherImpl {
    //http://op.juhe.cn/  baseurl
    //onebox/weather/query?  get地址
    //
    // cityname=深圳&key=4ea58de8a7573377cec0046f5e2469d5
    //ciryname key

    @GET("onebox/weather/query?")
    Call<WeatherDataBean> getWeather(@Query("cityname") String cityname, @Query("key") String key);
}
