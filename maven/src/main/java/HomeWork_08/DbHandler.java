package HomeWork_08;

import org.sqlite.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbHandler {

    private static final String DB_PATH = "jdbc:sqlite:DB_Weather.db";
    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.deregisterDriver(new JDBC());
        connection = DriverManager.getConnection(DB_PATH);
    }

    public void AddLog(WeatherLog weatherLog){
        String [][] forecast = weatherLog.getForecast();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        for (int i = 0; i < 5; i++) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Weather(Date, City, City_ID, Forecast_Date, Forecast_Text, Temp_Min, Temp_Max) VALUES(?, ?, ?, ?, ?, ?, ?)"
            )) {
                preparedStatement.setObject(1, date);
                preparedStatement.setObject(2, weatherLog.getCity());
                preparedStatement.setObject(3, weatherLog.getCity_id());
                preparedStatement.setObject(4, forecast[i][0]);
                preparedStatement.setObject(5, forecast[i][1]);
                preparedStatement.setObject(6, forecast[i][2]);
                preparedStatement.setObject(7, forecast[i][3]);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<WeatherFlat> getAllForecasts(){
        List<WeatherFlat> weatherFlat = new ArrayList<>();

        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT Date, City, City_ID, Forecast_Date, Forecast_Text, Temp_Min, Temp_Max FROM Weather");
            while (resultSet.next()){
                weatherFlat.add(
                            new WeatherFlat(
                                            resultSet.getString("Date"),
                                    resultSet.getString("City"),
                                    resultSet.getInt("City_ID"),
                                    resultSet.getString("Forecast_Date"),
                                    resultSet.getString("Forecast_Text"),
                                    resultSet.getDouble("Temp_Min"),
                                    resultSet.getDouble("Temp_Max")
                            ));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return weatherFlat;
    }
}
