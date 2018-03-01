package turbo;

import turbo.parser.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qenlin on 01.03.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StartingInfo startingInfoByKamil = new FileReader("a_example.in").getStartingInfo();

        List<Car> cars = createCars(startingInfoByKamil.getFleet());

        System.out.println(startingInfoByKamil);

        Integer time = 0;
        Integer maxNumberOfTrip = startingInfoByKamil.getTime();

        while (time < maxNumberOfTrip) {


            time++;
        }
    }

    private static List<Car> createCars(int number) {
        List<Car> cars = new ArrayList<>();

        return cars;
    }
}
