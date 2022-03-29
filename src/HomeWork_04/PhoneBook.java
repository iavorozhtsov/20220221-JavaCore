package HomeWork_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> rec = new HashMap<>();

    public void add(String name, String phone){
        ArrayList<String> tmp = new ArrayList<>();

        if (rec.get(name) == null){
            tmp.add(phone);
            rec.put(name, tmp);
        }
        else {
            rec.get(name).add(phone);
        }
    }

    public String get(String name){
        if (rec.get(name) == null){
            return "Имя " + name + " в справочнике не найдено.";
        }
        else {
            return "У " + name + " найдены следующие номера: " + rec.get(name).toString();
        }
    }
}
