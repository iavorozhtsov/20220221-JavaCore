package HomeWork_04;

import java.util.HashMap;
import java.util.Locale;

public class MainApp_04 {
    public static void main(String[] args){
        //Part_01

        String words = "Создать массив с набором слов (10-20 слов , должны встречаться повторяющиеся ). " +
                "Найти и вывести список уникальных слов , из которых состоит массив ( дубликаты не считаем ). " +
                "Посчитать , сколько раз встречается каждое слово";
        String[] wordsArr;
        HashMap <String, Integer> wordsCount = new HashMap<>();

        words = words.toLowerCase();
        wordsArr = words.split(" ");

        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsCount.get(wordsArr[i]) == null){
                wordsCount.put(wordsArr[i], 1);
            }
            else {
                wordsCount.put(wordsArr[i], wordsCount.get(wordsArr[i]) + 1);
            }
        }

        System.out.println(wordsCount + "\n*******************");

        //Part_02
        PhoneBook pb = new PhoneBook();
        pb.add("Ivanov", "+71111234567");
        pb.add("Ivanov", "+72221234567");
        pb.add("Petrov", "+73331234567");
        pb.add("Sidorov", "+74441234567");
        pb.add("Ovechkin", "+75551234567");

        System.out.println(pb.get("Vasechkin"));
        System.out.println(pb.get("Ovechkin"));
        System.out.println(pb.get("Ivanov"));

    }
}
