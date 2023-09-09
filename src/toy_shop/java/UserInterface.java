import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    final String MENU = "1. Добавить новую игрушку.\n" +
            "2. Загрузить все игрушки.\n" +
            "3. Изменить рейтинг игрушки.\n" +
            "4. Разыграть игрушки.\n" +
            "5. Выход.\n";

    public void menu() throws IOException {
        String name;
        int quantity;
        double frequency;
        int lineNumber;
        Double newFrequency;
        Scanner scan = new Scanner(System.in);
        ReadCSV rcvs = new ReadCSV();
        List<Toy> toys = rcvs.readFile();
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println(MENU);
            String user_choose = scan.nextLine();
            if (user_choose.equals("1")) {
                System.out.println("Введите данные новой игрушки");
                while (true) {
                    System.out.println("Введете название игрушки: ");
                    name = scan.nextLine();
                    if (Checker.isNotEmpty(name)) {
                        break;
                    } else {
                        System.out.println("Вы ввели пустую строку. Попробуйте снова.");
                    }
                }
                while (true) {
                    System.out.println("Введите количество игрушек: ");
                    String quant = scan.nextLine();
                    if (Checker.isNumeric(quant)) {
                        quantity = Integer.parseInt(quant);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Попробуйте снова.");
                    }
                }
                while (true) {
                    System.out.println("Введите частоту выпадения игрушки(от 0 до 100 %): ");
                    String frequencyTemp = scan.nextLine();
                    if (Checker.isReal(frequencyTemp) && Checker.isCorrectValue(frequencyTemp)) {
                        frequency = Double.parseDouble(frequencyTemp);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Попробуйте снова.");
                    }
                }
                int len = toys.size() + 1;
                Toy toy = new Toy(len, name, quantity, frequency);
                Game game = new Game();
                game.addToy(toys, toy);

            } else if (user_choose.equals("2")) {
                if (toys.size() != 0) {
                    PrintFile.printFile(toys);
                } else {
                    System.out.println("Нет доступных игрушек. Необходимо создать игрушку.");
                }

            } else if (user_choose.equals("3")) {
                if (toys.size() != 0) {
                    while (true) {
                        System.out.println("Введите номер записи, которую хотите изменить: ");
                        String lineNumb = scan.nextLine();
                        if (Checker.isNumeric(lineNumb) && Integer.parseInt(lineNumb) <= toys.size()) {
                            lineNumber = Integer.parseInt(lineNumb);
                            break;
                        } else {
                            System.out.println("Не корректный ввод. Попробуйте снова.");
                        }
                    }
                    while (true) {
                        System.out.println("Введите новое значение частоты выпадания игрушки в процентах от 0 до 100: ");
                        String frequencyTemp1 = scan.nextLine();
                        if (Checker.isReal(frequencyTemp1) && Checker.isCorrectValue(frequencyTemp1)) {
                            newFrequency = Double.parseDouble(frequencyTemp1);
                            break;
                        } else {
                            System.out.println("Вы ввели не число. Попробуйте снова.");
                        }
                    }
                    toys.get(lineNumber - 1).setFrequency(newFrequency);
                } else {
                    System.out.println("Нет игрушек для изменения. Создайте игрушку.");
                }
            } else if (user_choose.equals("4")) {
                System.out.println("4");
                Game game = new Game();
                game.elementWeight(toys);
            } else if (user_choose.equals("5")) {
                System.out.println("Программа завершила свою работу.");
                if (toys.size() != 0) {
                    SaveCSV csv = new SaveCSV();
                    csv.writeResult(toys.get(0), false);
                    toys.remove(0);
                    for (Toy item : toys) {
                        csv.writeResult(item, true);
                    }
                    break;
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }
    }
}
