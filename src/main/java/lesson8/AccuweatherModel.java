package lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson8.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = "KV6JxDKZT7NICgGg97yHS9AruhCoOAjD";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public  void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = Objects.requireNonNull(oneDayForecastResponse.body()).string();
                System.out.println(weatherResponse);
                String minTempInF = objectMapper.readTree(weatherResponse).at("/DailyForecasts").
                        get(0).at("/Temperature/Minimum/Value").asText();
                String manTempInF = objectMapper.readTree(weatherResponse).at("/DailyForecasts").
                        get(0).at("/Temperature/Maximum/Value").asText();
                String date = objectMapper.readTree(weatherResponse).at("/DailyForecasts").
                        get(0).at("/Date").asText();


                break;

            case FIVE_DAYS:

                break;
        }
    }
    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = Objects.requireNonNull(response.body()).string();

        String cityKey;
        cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

}
