package turbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static turbo.CarStatus.IN_RIDE;
import static turbo.RideStatus.DURING_RIDE;
import static turbo.RideStatus.FINISHED;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private Position position = new Position(0, 0);
    private Ride assignedRide;
    private CarStatus status = CarStatus.BENCH;

    public void moveToTarget(Position targetPosition) {
        moveHorizontal(targetPosition);

        if (assignedRide.getRideStatus().equals(DURING_RIDE) && position.equals(assignedRide.getFinishPoint())) {
            setStatus(CarStatus.BENCH);
            assignedRide.setRideStatus(FINISHED);
        }

        if (assignedRide.getRideStatus().equals(RideStatus.WAITING_FOR_CAR) && position.equals(assignedRide.getStartPoint())) {
            setStatus(IN_RIDE);
            assignedRide.setRideStatus(DURING_RIDE);
        }

    }
    
    public void assignedRide(Ride ride){
        this.assignedRide = ride;
        this.status = CarStatus.IN_RIDE;
    }

    private void moveHorizontal(Position targetPosition) {
        Integer target = targetPosition.getXAxis();
        if (targetPosition.getXAxis() == target) {
            moveVertical(targetPosition);
            return;
        }

        if (targetPosition.getXAxis() < target) {
            targetPosition.setXAxis(targetPosition.getXAxis() + 1);
            return;
        }

        if (targetPosition.getXAxis() > target) {
            targetPosition.setXAxis(targetPosition.getXAxis() - 1);
            return;
        }
    }

    private void moveVertical(Position targetPosition) {

        Integer target = targetPosition.getYAxis();
        if (targetPosition.getYAxis() == target) {
            return;
        }

        if (targetPosition.getYAxis() < target) {
            targetPosition.setYAxis(targetPosition.getYAxis() + 1);
            return;
        }
        if (targetPosition.getYAxis() > target) {
            targetPosition.setYAxis(targetPosition.getYAxis() - 1);
            return;
        }

    }
}
