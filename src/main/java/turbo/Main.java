package turbo;

import turbo.parser.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Qenlin on 01.03.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StartingInfo startingInfoByKamil = new FileReader("a_example.in").getStartingInfo();

        List<Car> cars = createCars(startingInfoByKamil.getFleet());

        Integer time = 0;

        ListIterator<Ride> iterator = startingInfoByKamil.getRides().listIterator();


        while (time < startingInfoByKamil.getTime()) {

            List<Car> freeCar = cars.stream()
                    .filter(car -> CarStatus.BENCH.equals(car.getStatus()))
                    .collect(Collectors.toList());

            System.out.println(freeCar);


            freeCar.stream()
                    .forEach(car -> {
                        if (iterator.hasNext()) {
                            car.assignedRide(iterator.next());
                        }
                    });

            //assign car to route

            //make moves

            //release car

            time++;
        }
    }

    private static List<Car> createCars(int number) {
        List<Car> cars = new ArrayList<>();
        IntStream.of(number)
                .forEach(t -> cars.add(new Car()));
        return cars;
    }
}
