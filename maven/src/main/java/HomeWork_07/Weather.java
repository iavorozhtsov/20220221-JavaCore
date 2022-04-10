package HomeWork_07;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Weather {
    private final String API_KEY = "nWRT4fUP2KGWG92DbLSz2zWDHF3eylwP";
    String city;

    public Weather(String city){
        this.city = city;
    }

    public String getWeather(){
        return getForecast(getCityID(city));
    }

    public String getCityID(String city){
        String respJson;

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper om = new ObjectMapper();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request req = new Request.Builder()
                .url(httpUrl)
                .build();

        Response resp = null;

//Заглушка, чтобы проверить логику работы без лишних запросов.
//Убрать после отладки!
//        respJson = "[{\"Version\":1,\"Key\":\"295212\",\"Type\":\"City\",\"Rank\":11,\"LocalizedName\":\"Saint Petersburg\",\"EnglishName\":\"Saint Petersburg\",\"PrimaryPostalCode\":\"\",\"Region\":{\"ID\":\"ASI\",\"LocalizedName\":\"Asia\",\"EnglishName\":\"Asia\"},\"Country\":{\"ID\":\"RU\",\"LocalizedName\":\"Russia\",\"EnglishName\":\"Russia\"},\"AdministrativeArea\":{\"ID\":\"SPE\",\"LocalizedName\":\"Saint Petersburg\",\"EnglishName\":\"Saint Petersburg\",\"Level\":1,\"LocalizedType\":\"Federal City\",\"EnglishType\":\"Federal City\",\"CountryID\":\"RU\"},\"TimeZone\":{\"Code\":\"MSK\",\"Name\":\"Europe/Moscow\",\"GmtOffset\":3.0,\"IsDaylightSaving\":false,\"NextOffsetChange\":null},\"GeoPosition\":{\"Latitude\":59.939,\"Longitude\":30.315,\"Elevation\":{\"Metric\":{\"Value\":10.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":32.0,\"Unit\":\"ft\",\"UnitType\":0}}},\"IsAlias\":false,\"SupplementalAdminAreas\":[{\"Level\":2,\"LocalizedName\":\"Tsentralny\",\"EnglishName\":\"Tsentralny\"}],\"DataSets\":[\"AirQualityCurrentConditions\",\"AirQualityForecasts\",\"Alerts\",\"DailyPollenForecast\",\"ForecastConfidence\",\"FutureRadar\",\"MinuteCast\",\"Radar\"]},{\"Version\":1,\"Key\":\"2201347\",\"Type\":\"City\",\"Rank\":385,\"LocalizedName\":\"Saint Petersburg\",\"EnglishName\":\"Saint Petersburg\",\"PrimaryPostalCode\":\"80728\",\"Region\":{\"ID\":\"NAM\",\"LocalizedName\":\"North America\",\"EnglishName\":\"North America\"},\"Country\":{\"ID\":\"US\",\"LocalizedName\":\"United States\",\"EnglishName\":\"United States\"},\"AdministrativeArea\":{\"ID\":\"CO\",\"LocalizedName\":\"Colorado\",\"EnglishName\":\"Colorado\",\"Level\":1,\"LocalizedType\":\"State\",\"EnglishType\":\"State\",\"CountryID\":\"US\"},\"TimeZone\":{\"Code\":\"MDT\",\"Name\":\"America/Denver\",\"GmtOffset\":-6.0,\"IsDaylightSaving\":true,\"NextOffsetChange\":\"2022-11-06T08:00:00Z\"},\"GeoPosition\":{\"Latitude\":40.556,\"Longitude\":-102.817,\"Elevation\":{\"Metric\":{\"Value\":1290.0,\"Unit\":\"m\",\"UnitType\":5},\"Imperial\":{\"Value\":4231.0,\"Unit\":\"ft\",\"UnitType\":0}}},\"IsAlias\":false,\"SupplementalAdminAreas\":[{\"Level\":2,\"LocalizedName\":\"Logan\",\"EnglishName\":\"Logan\"}],\"DataSets\":[\"AirQualityCurrentConditions\",\"AirQualityForecasts\",\"Alerts\",\"DailyAirQualityForecast\",\"DailyPollenForecast\",\"ForecastConfidence\",\"FutureRadar\",\"MinuteCast\",\"Radar\"]}]";

        try {
            resp = okHttpClient.newCall(req).execute();
            respJson = resp.body().string();

            if (om.readTree(respJson).get(0) == null) {
                System.out.println("City " + city + " was not found.");
                System.exit(1);
            }

            return om.readTree(respJson)
                    .get(0)
                    .at("/Key").toString().replace("\"","");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getForecast(String cityID){
        String respJson = "";
        String returnStr = "";

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper om = new ObjectMapper();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityID)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", "true")
                .addQueryParameter("language", "ru-ru")
                .build();

        Request req = new Request.Builder()
                .url(httpUrl)
                .build();

//        respJson = "{\"Headline\":{\"EffectiveDate\":\"2022-04-05T07:00:00+03:00\",\"EffectiveEpochDate\":1649131200,\"Severity\":3,\"Text\":\"Mixed rain and snow Tuesday\",\"Category\":\"snow/rain\",\"EndDate\":\"2022-04-05T19:00:00+03:00\",\"EndEpochDate\":1649174400,\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us\"},\"DailyForecasts\":[{\"Date\":\"2022-04-02T07:00:00+03:00\",\"EpochDate\":1648872000,\"Temperature\":{\"Minimum\":{\"Value\":-10.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":0.9,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":3,\"IconPhrase\":\"Partly sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":38,\"IconPhrase\":\"Mostly cloudy\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us\"},{\"Date\":\"2022-04-03T07:00:00+03:00\",\"EpochDate\":1648958400,\"Temperature\":{\"Minimum\":{\"Value\":-4.6,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":1.8,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":3,\"IconPhrase\":\"Partly sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":38,\"IconPhrase\":\"Mostly cloudy\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us\"},{\"Date\":\"2022-04-04T07:00:00+03:00\",\"EpochDate\":1649044800,\"Temperature\":{\"Minimum\":{\"Value\":-1.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":3.1,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":7,\"IconPhrase\":\"Cloudy\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":19,\"IconPhrase\":\"Flurries\",\"HasPrecipitation\":true,\"PrecipitationType\":\"Snow\",\"PrecipitationIntensity\":\"Light\"},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us\"},{\"Date\":\"2022-04-05T07:00:00+03:00\",\"EpochDate\":1649131200,\"Temperature\":{\"Minimum\":{\"Value\":-2.4,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":4.0,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":29,\"IconPhrase\":\"Rain and snow\",\"HasPrecipitation\":true,\"PrecipitationType\":\"Mixed\",\"PrecipitationIntensity\":\"Light\"},\"Night\":{\"Icon\":22,\"IconPhrase\":\"Snow\",\"HasPrecipitation\":true,\"PrecipitationType\":\"Snow\",\"PrecipitationIntensity\":\"Light\"},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us\"},{\"Date\":\"2022-04-06T07:00:00+03:00\",\"EpochDate\":1649217600,\"Temperature\":{\"Minimum\":{\"Value\":-6.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":2.0,\"Unit\":\"C\",\"UnitType\":17}},\"Day\":{\"Icon\":4,\"IconPhrase\":\"Intermittent clouds\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":22,\"IconPhrase\":\"Snow\",\"HasPrecipitation\":true,\"PrecipitationType\":\"Snow\",\"PrecipitationIntensity\":\"Light\"},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us\"}]}";

        try {
            Response resp = okHttpClient.newCall(req).execute();
            respJson = resp.body().string();
            for (int i = 0; i < 5; i++) {
                returnStr += "В городе: " + city + " на дату ";
                returnStr += om.readTree(respJson)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Date").toString().substring(1,11);
                returnStr += " ожидается " + om.readTree(respJson)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Day/IconPhrase").toString().replace("\"","");
                returnStr += ". Температура днём: " + om.readTree(respJson)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Temperature/Maximum/Value").toString() + " C,";
                returnStr += " ночью: " + om.readTree(respJson)
                        .at("/DailyForecasts")
                        .get(i)
                        .at("/Temperature/Minimum/Value").toString() + " C.\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnStr;
    }
}