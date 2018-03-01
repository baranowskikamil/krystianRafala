package turbo;

import turbo.parser.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static turbo.CarStatus.BENCH;

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
            System.out.println(cars);

            List<Car> freeCar = cars.stream()
                    .filter(car -> BENCH.equals(car.getStatus()))
                    .collect(Collectors.toList());




            freeCar.stream()
                    .forEach(car -> {
                        if (iterator.hasNext()) {
                            car.assignedRide(iterator.next());
                        }
                    });

            Integer finalTime = time;
            cars.stream()
                    .forEach(car -> {
                        if (car.getAssignedRide().getRideStatus().equals(RideStatus.WAITING_FOR_CAR)
                                && car.getStatus().equals(CarStatus.IN_RIDE)) {

                            System.out.println("A");

                            car.moveToTarget(car.getAssignedRide().getStartPoint(), finalTime);
                            return;
                        }
                        if (car.getAssignedRide().getRideStatus().equals(RideStatus.DURING_RIDE)
                                && car.getStatus().equals(CarStatus.IN_RIDE)) {

                            System.out.println("B");

                            car.moveToTarget(car.getAssignedRide().getFinishPoint(), finalTime);
                            return;
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
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
