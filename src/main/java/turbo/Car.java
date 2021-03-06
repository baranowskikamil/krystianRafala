package turbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static turbo.CarStatus.IN_RIDE;
import static turbo.CarStatus.WAITING_FOR_RIDE;
import static turbo.RideStatus.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private Position position = new Position(0, 0);
    private Ride assignedRide;
    private CarStatus status = CarStatus.BENCH;
    private List<Integer> krystian = new ArrayList<>();

    public void moveToTarget(Position targetPosition, Integer time) {

        if (!(assignedRide.getRideStatus().equals(RideStatus.WAITING_FOR_START)
                && status.equals(WAITING_FOR_RIDE)
                && time < assignedRide.getEarlierStart())) {
            status = IN_RIDE;
            assignedRide.setRideStatus(RideStatus.DURING_RIDE);
        }

        if (status.equals(IN_RIDE)) {
            moveHorizontal(targetPosition);
        }

        if (assignedRide.getRideStatus().equals(DURING_RIDE) && position.equals(assignedRide.getFinishPoint())) {
            setStatus(CarStatus.BENCH);
            assignedRide.setRideStatus(FINISHED);
        }

        if (assignedRide.getRideStatus().equals(RideStatus.WAITING_FOR_CAR) && position.equals(assignedRide.getStartPoint())) {
            if (time < assignedRide.getEarlierStart()) {
                setStatus(WAITING_FOR_RIDE);
                assignedRide.setRideStatus(WAITING_FOR_START);
                return;
            }
            setStatus(IN_RIDE);
            assignedRide.setRideStatus(DURING_RIDE);
        }
    }

    public void assignedRide(Ride ride, Integer rrr) {
        ride.setRideStatus(RideStatus.WAITING_FOR_CAR);
        krystian.add(rrr);
        this.assignedRide = ride;
        this.status = CarStatus.IN_RIDE;
    }

    private void moveHorizontal(Position targetPosition) {
        Integer target = targetPosition.getXAxis();
        if (this.getPosition().getXAxis().equals(target)) {
            moveVertical(targetPosition);
            return;
        }

        if (this.getPosition().getXAxis() < target) {
            this.position.setXAxis(this.position.getXAxis() + 1);
            return;
        }

        if (this.getPosition().getXAxis() > target) {
            this.position.setXAxis(this.position.getXAxis() - 1);
            return;
        }
    }

    private void moveVertical(Position targetPosition) {
        Integer target = targetPosition.getYAxis();
        if (this.getPosition().getYAxis().equals(target)) {
            return;
        }

        if (this.getPosition().getYAxis() < target) {

            this.position.setYAxis(this.position.getYAxis() + 1);
            return;
        }
        if (this.getPosition().getYAxis() > target) {
            this.position.setYAxis(this.position.getYAxis() - 1);
            return;
        }

    }
}
