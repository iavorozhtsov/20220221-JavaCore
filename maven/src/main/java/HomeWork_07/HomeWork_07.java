package HomeWork_07;



import java.io.IOException;
import java.util.Scanner;

public class HomeWork_07 {
    public static void main(String[] args) throws IOException {
        String req;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("For exit enter 'Q' else enter city name: ");
            req = sc.nextLine();
            if (req.toLowerCase().equals("q")) {
                break;
            }
            else {
                Weather w = new Weather(req);
                System.out.println(w.getWeather());
            }
        }

    }
}
