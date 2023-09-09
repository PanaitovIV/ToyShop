import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public List<Toy> elementWeight(List<Toy> toyList){
        PrintFile pf = new PrintFile();
        if (toyList.size() > 0){
            ArrayList<Double> weights = new ArrayList<>();
            double sumWeight = 1;
            double count_freaq = 0;
            for (Toy item: toyList) {
                weights.add(item.getFrequency());
                sumWeight += item.getFrequency();
            }
            Random rnd = new Random();
            int rndNumber = rnd.nextInt(1, (int) sumWeight);
            for (Toy item: toyList) {
                count_freaq += item.getFrequency();
                if (count_freaq >= rndNumber){
                    if (item.getQuantity() > 0){
                        System.out.printf("Игрушка: %s, %d\n", item.getName(), item.getQuantity());
                        item.setQuantity(item.getQuantity() - 1);
                        break;
                    }else{
                        System.out.printf("Игрушка: %s, %d\n", item.getName(), item.getQuantity());
                        toyList.remove(item);
                        break;
                    }
                }
            }
        }else{
            System.out.println("Игрушки отсутствуют");
        }
        return toyList;
    }
    public List<Toy> addToy(List<Toy> toys, Toy toy){
        for (Toy item: toys) {
            if (item.getName().equals(toy.getName())){
                item.setQuantity(item.getQuantity() + toy.getQuantity());
                System.out.println("Такая игрушка уже есть");
                return toys;
            }
        }
        toys.add(toy);
        return toys;
    }
    public List<Toy> createToys(){
        Toy toy1 = new Toy(1, "Котенок", 10, 99);
        Toy toy2 = new Toy(2, "Собака", 10, 89);
        Toy toy3 = new Toy(3, "Волк", 10, 79);
        Toy toy4 = new Toy(4, "Лиса", 10, 69);
        Toy toy5 = new Toy(5, "Ежик", 10, 59);
        Toy toy6 = new Toy(6, "Дельфин", 10, 49);
        Toy toy7 = new Toy(7, "Зайчик", 10, 39);
        Toy toy8 = new Toy(8, "Чебурашка", 10, 29);
        Toy toy9 = new Toy(9, "Медведь", 10, 19);
        Toy toy10 = new Toy(10, "Акула", 10, 9);
        List<Toy> toys = new ArrayList<>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        toys.add(toy5);
        toys.add(toy6);
        toys.add(toy7);
        toys.add(toy8);
        toys.add(toy9);
        toys.add(toy10);
        return toys;
    }
}
