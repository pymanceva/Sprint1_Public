public class Converter {
    double convertStepsIntoKm(int steps) {
        double distanceKm = steps * 75 / 100000;
        return distanceKm;
    }
    int convertStepsIntoCalories(int steps) {
        int spentCalories = steps * 50 / 1000;
        return spentCalories;
    }

}
