package observer;

import utils.Logger;

public class AirConditioning implements Observer {
    @Override
    public void update(boolean isOccupied) {
        if (isOccupied) {
            Logger.log("Air Conditioning and lights turned ON.");
        } else {
            Logger.log("Air Conditioning and lights turned OFF.");
        }
    }
}
