import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.Position;

/**
 * Created by Qenlin on 01.03.2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private Pair position;
    private RideStatus status;

}
