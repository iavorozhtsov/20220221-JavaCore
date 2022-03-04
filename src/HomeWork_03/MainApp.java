package HomeWork_03;

import java.util.Random;

public class MainApp {
    public static void main(String[] args){
        Random rnd = new Random();
        int fruitCount = 5 + rnd.nextInt(20);
        int applesCount = 0;
        int orangesCount = 0;

        FruitBox fb1 = new FruitBox();
        FruitBox fb2 = new FruitBox();
        FruitBox fb3 = new FruitBox();
        FruitBox fb4 = new FruitBox();

        //Заполняем коробки случайным количеством фруктов
        //В коробке 1 всегда яблоки, в 2 - апельсины
        for (int i = 0; i < fruitCount; i++) {
            if (rnd.nextBoolean()){
                fb1.addItem(new Apple());
                applesCount++;
            }
            else {
                fb2.addItem(new Orange());
                orangesCount++;
            }
        }

        //Вывод общей информации
        System.out.println("***************\nFruitsCount: " + fruitCount + "\nApples:\t" + applesCount +
                "\nOranges:\t" + orangesCount + "\n***************\n");

        System.out.println("First box stores:\t" + fb1.getInfo());
        System.out.println("Second box stores:\t" + fb2.getInfo());
        System.out.println();

        //Кладём в 3 коробку яблоко и пересыпаем туда 1 коробку (с яблоками)
        fb3.addItem(new Apple());
        fb3.fillWith(fb1);
        System.out.println("Third box stores:\t" + fb3.getInfo());

        //Пробуем пересыпать в 3 коробку 2 (с апельсинами)
        fb3.fillWith(fb2);

        //Кладём в 4 коробку апельсин и пересыпаем туда 2 коробку (с апельсинами)
        fb4.addItem(new Orange());
        fb4.fillWith(fb2);
        System.out.println("Fourth box stores:\t" + fb4.getInfo());
        System.out.println();

        //Очищаем коробки и наполняем их для сравнения
        fb3.clearBox();
        fb3.addItem(new Apple());
        fb3.addItem(new Apple());
        fb3.addItem(new Apple());
        System.out.println("Third box stores:\t" + fb3.getInfo());

        fb4.clearBox();
        fb4.addItem(new Orange());
        fb4.addItem(new Orange());
        System.out.println("Fourth box stores:\t" + fb4.getInfo());

        System.out.println("Is third and fourth boxes are equals?\t" + fb3.compareWith(fb4));
        System.out.println("Is fourth and third boxes are equals?\t" + fb4.compareWith(fb3));
    }
}
