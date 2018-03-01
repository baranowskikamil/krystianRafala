package turbo;

import javafx.util.Pair;
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
    private RideStatus status;

    public void moveToTarget() {
        moveHorizontal();
        moveVertical();

    }

    private void moveHorizontal() {
        if (position.getXAxis() == assignedRide.getStartPoint().getXAxis()) {
            return;
        }

        if (position.getYAxis() < assignedRide.getStartPoint().getYAxis()) {
            position.setXAxis();
            }
    }
}
