package HomeWork_08;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HomeWork_08 {
    public static void main(String[] args) throws IOException {
        String req;
        Scanner sc = new Scanner(System.in);

        try {
            DbHandler dbHandler = new DbHandler();
            while (true) {
                System.out.print("For exit enter 'Q'\nFor read forecasts form database enter 'R'\nFor forecast request enter city name: ");
                req = sc.nextLine();
                if (req.toLowerCase().equals("q")) {
                    break;
                } else if (req.toLowerCase().equals("r")){
                    System.out.println(dbHandler.getAllForecasts());
                } else if (req.length() >1){
                    Weather w = new Weather(req);
                    System.out.println(w.getWeather());
                } else {
                    System.out.println("Введённое значение некорректно.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
