import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        SaveCSV csv = new SaveCSV();
        List<Toy> toys = game.createToys();
        csv.writeResult(toys.get(0), false);
        toys.remove(0);
        for (Toy item : toys) {
            csv.writeResult(item, true);
        }
        UserInterface us = new UserInterface();
        us.menu();
    }
}