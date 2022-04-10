package HomeWork_05;

import java.io.*;
import java.util.ArrayList;

public class AppData {
    private String[] header;
    private int[][] data;

    public boolean read (File filePath){
        String  tmp;

        try (BufferedReader rdr = new BufferedReader(new FileReader(filePath))){
            tmp = rdr.readLine();
            header = tmp.split(";");

            ArrayList<int[]> arrayList = new ArrayList<>();

            while((tmp = rdr.readLine()) != null){
                String[] s = tmp.split(";");
                int [] tmpInt = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    tmpInt[i] = Integer.parseInt(s[i]);
                }
                arrayList.add(tmpInt);
            }
            data = new int[arrayList.size()][];
            for (int i = 0; i < arrayList.size(); i++) {
                data[i] = arrayList.get(i);
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean save (File filePath){
        String tmp = "";

        for (int i = 0; i < header.length; i++){
            tmp+= header[i] + ";";
        }
        tmp+="\n";

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                tmp+= data[i][j] + ";";
            }
            tmp+="\n";
        }

        try(BufferedWriter wrt = new BufferedWriter(new FileWriter(filePath))){
            wrt.write(tmp);
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
