package JavaCore;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ForecastFetcher {
    private OkHttpClient httpClient = new OkHttpClient();
    private final String API_KEY = "163ac294-f0b3-4a54-8cb6-126ef0150520";
    private final double ST_PT_LAT = 59.9386;
    private final double ST_PT_LON = 30.3141;
    //GET https://api.weather.yandex.ru/v2/informers?lat=55.75396&lon=37.620393
    //X-Yandex-API-Key: 3fc...7
    private final String BASE_HOST = "api.weather.yandex.ru";
    private final String API_VERSION = "v2";
    private final String FORECAST_API = "forecast";



    public String fetchForecast() throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_API)
                .addQueryParameter("lat", String.valueOf(ST_PT_LAT))
                .addQueryParameter("lon", String.valueOf(ST_PT_LON))
                .addQueryParameter("limit", String.valueOf(5))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", API_KEY)
                .build();

        Response response = httpClient.newCall(request).execute();
        String body = response.body().string();
        return body;

    }
}
