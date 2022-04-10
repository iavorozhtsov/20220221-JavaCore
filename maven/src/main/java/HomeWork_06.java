import okhttp3.*;

import java.io.IOException;

public class HomeWork_06 {
    public static void main(String[] args) throws IOException {
        final String API_KEY = "nWRT4fUP2KGWG92DbLSz2zWDHF3eylwP";
        final String CITY = "295212";

        OkHttpClient okHttpClient = new OkHttpClient();

/*        HttpUrl httpUrl = new HttpUrl.Builder()
                .host("http://dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "nWRT4fUP2KGWG92DbLSz2zWDHF3eylwP")
                .addQueryParameter("q", "295212")
                .build();
 */
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", "nWRT4fUP2KGWG92DbLSz2zWDHF3eylwP")
                .addQueryParameter("metric", "true")
                .build();

        Request req = new Request.Builder()
                .url(httpUrl)
                .build();

        Response resp = okHttpClient.newCall(req).execute();

        System.out.println(resp.body().string());

/*RESPONCE for next HomeWork
{
  "Headline": {
    "EffectiveDate": "2022-03-30T19:00:00+03:00",
    "EffectiveEpochDate": 1648656000,
    "Severity": 7,
    "Text": "Cold Wednesday night",
    "Category": "cold",
    "EndDate": "2022-03-31T07:00:00+03:00",
    "EndEpochDate": 1648699200,
    "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us",
    "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us"
  },
  "DailyForecasts": [
    {
      "Date": "2022-03-30T07:00:00+03:00",
      "EpochDate": 1648612800,
      "Temperature": {
        "Minimum": {
          "Value": -8.5,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": -2.1,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 20,
        "IconPhrase": "Mostly cloudy w/ flurries",
        "HasPrecipitation": true,
        "PrecipitationType": "Snow",
        "PrecipitationIntensity": "Light"
      },
      "Night": {
        "Icon": 38,
        "IconPhrase": "Mostly cloudy",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us"
    },
    {
      "Date": "2022-03-31T07:00:00+03:00",
      "EpochDate": 1648699200,
      "Temperature": {
        "Minimum": {
          "Value": -7.4,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 0.3,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 3,
        "IconPhrase": "Partly sunny",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 34,
        "IconPhrase": "Mostly clear",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us"
    },
    {
      "Date": "2022-04-01T07:00:00+03:00",
      "EpochDate": 1648785600,
      "Temperature": {
        "Minimum": {
          "Value": -7.1,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 2.9,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 4,
        "IconPhrase": "Intermittent clouds",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 7,
        "IconPhrase": "Cloudy",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us"
    },
    {
      "Date": "2022-04-02T07:00:00+03:00",
      "EpochDate": 1648872000,
      "Temperature": {
        "Minimum": {
          "Value": -6.5,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 2.7,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 4,
        "IconPhrase": "Intermittent clouds",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 35,
        "IconPhrase": "Partly cloudy",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us"
    },
    {
      "Date": "2022-04-03T07:00:00+03:00",
      "EpochDate": 1648958400,
      "Temperature": {
        "Minimum": {
          "Value": -5,
          "Unit": "C",
          "UnitType": 17
        },
        "Maximum": {
          "Value": 3.1,
          "Unit": "C",
          "UnitType": 17
        }
      },
      "Day": {
        "Icon": 2,
        "IconPhrase": "Mostly sunny",
        "HasPrecipitation": false
      },
      "Night": {
        "Icon": 38,
        "IconPhrase": "Mostly cloudy",
        "HasPrecipitation": false
      },
      "Sources": [
        "AccuWeather"
      ],
      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us",
      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us"
    }
  ]
}
 */
    }
}
