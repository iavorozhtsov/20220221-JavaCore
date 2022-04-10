package HomeWork_08;

public class WeatherLog {
    private String city;
    private int city_id;
    private String[][] forecast;
    private String forecast_string;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String[][] getForecast() {
        return forecast;
    }

    public void setForecast(String[][] forecast) {
        this.forecast = forecast;
    }

    public String getForecast_string() {
        return forecast_string;
    }

    public void setForecast_string(String forecast_string) {
        this.forecast_string = forecast_string;
    }

    @Override
    public String toString() {
        return forecast_string;
    }

    public WeatherLog(String city, int city_id, String[][] forecast) {
        this.city = city;
        this.city_id = city_id;
        this.forecast = forecast;
        forecast_string = "";

        for (int i = 0; i < this.forecast.length; i++) {
            forecast_string += "В городе " + city +
                    " на дату " + this.forecast[i][0] +
                    " ожидается " + this.forecast[i][1] +
                    ", температура днём " + this.forecast[i][2] + "С," +
                    " ночью " + this.forecast[i][3] + "С.\n";
        }
    }
}
