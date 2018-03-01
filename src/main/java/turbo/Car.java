package turbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private Position position = new Position(0, 0);
    private Ride assignedRide;
    private CarStatus status = CarStatus.BENCH;

    public void moveToTarget() {
        moveHorizontal();
        moveVertical();

    }

    public void assignedRide(Ride ride){
        this.assignedRide = ride;
        this.status = CarStatus.IN_RIDE;
    }

    private void moveHorizontal() {
        if (position.getXAxis() == assignedRide.getStartPoint().getXAxis()) {
            return;
        }

        if (position.getYAxis() < assignedRide.getStartPoint().getYAxis()) {
            position.setXAxis(0);
        }
    }

    private void moveVertical() {
        if (position.getYAxis() == assignedRide.getStartPoint().getYAxis()) {
            return;
        }

        if (position.getYAxis() < assignedRide.getStartPoint().getYAxis()) {
            position.setYAxis(position.getYAxis() + 1);
            return;
        }
        if (position.getYAxis() > assignedRide.getStartPoint().getYAxis()) {
            position.setYAxis(position.getYAxis() - 1);
            return;
        }

    }
}
