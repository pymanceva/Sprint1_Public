
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Привет!");
        System.out.println("Я твой StepTracker");
        chooseCommand();
    }
    static void chooseCommand() {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userCommand = sc.nextInt();
        while (userCommand != 0) {
            if (userCommand == 1) {
                stepTracker.saveSteps();
            } else if (userCommand == 2) {
                stepTracker.printStatistic();
            } else if (userCommand == 3) {
                stepTracker.changeGoal();
            } else {
                System.out.println("Команда введена неверно. Выберите одну из существующих команд");
            }
            printMenu();
            userCommand = sc.nextInt();
        }
        System.out.println("Программа завершена");
        }

    static void printMenu() {
        System.out.println("Что ты хочешь сделать?");
        System.out.println("1 - Внести шаги за день");
        System.out.println("2 - Узнать статистику");
        System.out.println("3 - Изменить цель на день");
        System.out.println("0 - Выход");
    }
}
