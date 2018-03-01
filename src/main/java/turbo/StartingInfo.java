package turbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StartingInfo {

    private Integer row;
    private Integer column;
    private Integer fleet;
    private Integer numberOfRides;
    private Integer bonus;
    private Integer time;
    private LinkedList<Ride> rides;
}
