import java.util.Scanner;
public class StepTracker {
    MonthData[] monthData;
    int stepsGoal = 10000;
    Converter converter = new Converter();
    Scanner sc = new Scanner(System.in);
    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }
    static class MonthData {
        int [] dayData;
            public MonthData() {
                dayData = new int [30];
                for (int i = 0; i < dayData.length; i++) {
                    dayData[i] = 0;
                }
            }
    }
    void saveSteps() {
        System.out.println("За какой месяц Вы хотите внести данные - от 0 до 11?");
        int month = sc.nextInt();
        while (true) {
            if (month >= 0 && month <= 11) {
                break;
            } else {
                System.out.println("Выбрано неверное значение. Попробуйте снова.");
            }
            System.out.println("За какой месяц Вы хотите внести данные - от 0 до 11?");
            month = sc.nextInt();
        }
        System.out.println("За какой день месяца Вы хотите внести данные - от 0 до 29?");
        int day = sc.nextInt();
        while (true) {
            if (day >= 0 && day <= 29) {
                break;
            } else {
                System.out.println("Выбрано неверное значение. Попробуйте снова.");
            }
            System.out.println("За какой день месяца Вы хотите внести данные - от 0 до 11?");
            day = sc.nextInt();
        }
        System.out.println("Введите количество шагов");
        int stepsPerDay = sc.nextInt();
        while (true) {
            if (stepsPerDay >= 0) {
                monthData[month].dayData[day] = stepsPerDay;
                System.out.println("Значение сохранено. Результат " + monthData[month].dayData[day] + " записан.");
                if (stepsPerDay >= stepsGoal) {
                    System.out.println("Цель достигнута! Так держать!");
                } else {
                    System.out.println("Вы можете лучше! Сегодня цель не достигнута.");
                }
                break;
            } else if (stepsPerDay < 0){
                System.out.println("Количество шагов не может быть меньше 0. Попробуйте снова");
            }
            System.out.println("Введите количество шагов");
            stepsPerDay = sc.nextInt();
        }
    }

    void printStatistic() {
        System.out.println("За какой месяц вы хотите получить информацию - от 0 до 11?");
        int month = sc.nextInt();
        while (true) {
            if (month >= 0 && month <= 11) {
                break;
            } else {
                System.out.println("Выбрано неверное значение. Попробуйте снова.");
            }
            System.out.println("За какой месяц Вы хотите внести данные - от 0 до 11?");
            month = sc.nextInt();
        }
        printAmountSteps(month);
        System.out.println("Общее количество шагов за месяц - " + findSumSteps(month));
        System.out.println("Максимальное количество шагов за день в месяце - " + findMaxSteps(monthData[month].dayData));
        System.out.println("Среднее количество шагов в день - " + findAverageSteps(month));
        System.out.println("За месяц Вы прошли " + converter.convertStepsIntoKm(findSumSteps(month)) + " километров");
        System.out.println("За месяц Вы сожгли " + converter.convertStepsIntoCalories(findSumSteps(month)) + " килокалорий");
        System.out.println("Лучшая серия в этом месяце (количество дней) : " + findBestSeries(month));
    }
    void changeGoal() {
        System.out.println("Введите новую цель");
        int goal = sc.nextInt();
        while (true) {
            if (goal >= 0) {
                stepsGoal = goal;
                System.out.println("Новая дневная цель - " + stepsGoal);
                break;
            } else {
                System.out.println("Суточная цель по шагам не может быть меньше нуля. Попробуйте еще раз");
            }
            System.out.println("Введите новую цель");
            goal = sc.nextInt();
        }

    }
    void printAmountSteps(int month) {
        for (int i = 0; i < (monthData[month].dayData.length - 1); i++) {
            System.out.print((i + 1) + " день: " + monthData[month].dayData[i] + ", ");
        }
        System.out.println((monthData[month].dayData.length) + " день: " + monthData[month].dayData[29]);
    }
    int findSumSteps(int month) {
        int stepsPerMonth = 0;
        for (int i = 0; i < monthData[month].dayData.length - 1; i++) {
            stepsPerMonth = stepsPerMonth + monthData[month].dayData[i];
        }
        return stepsPerMonth;
    }
    int findAverageSteps(int month) {
        int averageSteps = findSumSteps(month) / monthData[month].dayData.length;
        return averageSteps;
    }
    int findMaxSteps(int[] dayData) {
        int maxSteps = 0;
        for (int i = 0; i < dayData.length; i++) {
            if (dayData[i] > maxSteps) {
                maxSteps = dayData[i];
            }
        }
        return maxSteps;

    }
    int findBestSeries(int month) {
        int counter = 0;
        int counterMax = 0;
        for (int i = 0; i < monthData[month].dayData.length; i++ ) {
            if (monthData[month].dayData[i] >= stepsGoal) {
                counter++;
            } else {
                counter = 0;
            }
            if (counterMax < counter) {
                counterMax = counter;
            }
        }
        return counterMax;
    }

}
