package HomeWork_05;

import java.io.File;
import java.io.FileInputStream;

public class MainApp_05 {
    public static void main(String[] args){
        File filePath = new File("src/HomeWork_05/20220329.csv");

        if (!filePath.exists()) {
            System.out.println("File not found.");
            return;
        }

        AppData data = new AppData();
        if(data.read(filePath)){
            System.out.println("Данные прочитаны успешно.");
        }
        if(data.save(filePath)){
            System.out.println("Данные записаны успешно.");
        }

    }
}
