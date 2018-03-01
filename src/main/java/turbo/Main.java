package turbo;

import org.apache.commons.lang3.StringUtils;
import turbo.parser.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<Integer, List<Integer>> xd = new HashMap<>();
        List<Car> cars = createCars(startingInfoByKamil.getFleet());

        Integer time = 0;

        ListIterator<Ride> iterator = startingInfoByKamil.getRides().listIterator();


        while (time < startingInfoByKamil.getTime()) {

            List<Car> freeCar = cars.stream()
                    .filter(car -> BENCH.equals(car.getStatus()))
                    .collect(Collectors.toList());

//            freeCar.stream()
//                    .filter(t -> t.getStatus().equals(CarStatus.BENCH))
//                    .forEach(t -> {
//                                List<Integer> integers = xd.get(cars.indexOf(t));
//                                if (integers == null) {
//                                    integers = new LinkedList<>();
//                                }
//
//                                integers.add(startingInfoByKamil.getRides().indexOf(t.getAssignedRide()));
//                                xd.put(freeCar.indexOf(t), integers);
//
//                            }
//                    );

//            System.out.println(freeCar);


            freeCar.stream()
                    .forEach(car -> {
                        if (iterator.hasNext()) {
                            car.assignedRide(iterator.next(), iterator.nextIndex() - 1);
                        }
                    });

            Integer finalTime = time;
            cars.stream()
                    .forEach(car -> {
                        if (car.getAssignedRide().getRideStatus().equals(RideStatus.WAITING_FOR_CAR)
                                && car.getStatus().equals(CarStatus.IN_RIDE)) {


                            car.moveToTarget(car.getAssignedRide().getStartPoint(), finalTime);
                            return;
                        }
                        if (car.getAssignedRide().getRideStatus().equals(RideStatus.DURING_RIDE)
                                && car.getStatus().equals(CarStatus.IN_RIDE)) {


                            car.moveToTarget(car.getAssignedRide().getFinishPoint(), finalTime);
                            return;
                        }
                        if (car.getAssignedRide().getRideStatus().equals(RideStatus.WAITING_FOR_START)
                                && car.getStatus().equals(CarStatus.WAITING_FOR_RIDE)) {


                            car.moveToTarget(car.getAssignedRide().getFinishPoint(), finalTime);
                            return;
                        }
                    });


            //assign car to route

            //make moves

            //release car

            time++;
        }

        for(Car car: cars){
            System.out.print(car.getKrystian().size()+" ");
            car.getKrystian().forEach(t->System.out.print(t+" "));
            System.out.println();
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
