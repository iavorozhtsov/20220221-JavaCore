package HomeWork_03;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private ArrayList <T> al = new ArrayList<>();

    public double getBoxWeigh(){
        double weight = 0;
        if (!al.isEmpty()){
            for (int i = 0; i < al.size(); i++) {
                weight += al.get(i).getWeight();
            }
        }
        return weight;
    }

    public void addItem(T t){
        if(al.isEmpty() || al.get(0).getClass() == t.getClass()) {
            al.add(t);
        }
        else{
            System.out.println("In this box stored another fruits!");
//            System.out.println("This box only for " + t.getClass());
        }
    }

    public void delItem(int i){
        al.remove(i);
    }

    public int getBoxItemsCount(){
        return al.size();
    }

    public boolean compareWith (FruitBox f){
        return this.getBoxWeigh() == f.getBoxWeigh();
    }

    public String getFruitType(){
        if (al.size() == 0) {
            return "Empty";
        }
        else {
            return al.get(0).getType();
        }
    }

    public T getFruit(){
        if (getFruitType() == "Apple"){
            return (T) new Apple();
        }
        else {
            return (T) new Orange();
        }
    }

    public void fillWith(FruitBox f){
        if (f.getBoxWeigh() == 0) return;
        if (this.al.isEmpty() || getFruitType().equals(f.getFruitType())){
            for (int i = 0; i < f.getBoxItemsCount(); i++) {
                addItem((T) f.getFruit());
            }
            f.clearBox();
        }
        else{
            System.out.println("Cannot merge boxes. In this box stored another fruits!");
//            System.out.println("This box only for " + t.getClass());
        }
    }

    public String getInfo(){
        return getBoxItemsCount() + " of " + getFruitType() + ".\nBox weight:\t" + getBoxWeigh();
    }

    public void clearBox(){
        al.clear();
    }
}
