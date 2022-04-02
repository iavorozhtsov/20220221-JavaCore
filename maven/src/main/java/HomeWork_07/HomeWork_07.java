package HomeWork_07;



import java.io.IOException;
import java.util.Scanner;

public class HomeWork_07 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter city name: ");
        Weather w = new Weather(sc.nextLine());

        System.out.println(w.getWeather());

    }
}
