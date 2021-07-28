package llesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList<>();

    public Box() {

    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);

    } public boolean isSameAvg(Box<?> boxToCompare) {
        return Math.abs(getWeight() - boxToCompare.getWeight()) < 0.0001;
    }

    public float getWeight() {
        return fruitList.size() * fruitList.get(0).getWeight();
    }

    public void pourOver(Box<T> box) {
        box.getFruitList().addAll(fruitList);
        fruitList.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitList=" + fruitList +
                '}';
    }
}
