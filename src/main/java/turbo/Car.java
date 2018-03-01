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
    private Position position;
    private Ride assignedRide;
    private CarStatus status;

    public void moveToTarget() {
        moveHorizontal();
        moveVertical();

    }

    private void moveVertical() {
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
            position.setYAxis(position.getYAxis()+1);
            return;
        }
        if (position.getYAxis() > assignedRide.getStartPoint().getYAxis()) {
            position.setYAxis(position.getYAxis()-1);
            return;
        }

    }
}
