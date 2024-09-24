package observer;

import config.OfficeConfiguration;
import utils.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class OccupancySensor {
    private Observer airConditioning;
    private int occupants;
    private int roomId;
    private Timer timer;

    public OccupancySensor(int roomId) {
        this.roomId = roomId;
        this.timer = new Timer();
    }

    public void addObserver(Observer observer) {
        this.airConditioning = observer;
    }

    public void setOccupancy(int count) {
        OfficeConfiguration config = OfficeConfiguration.getInstance();
        if (!config.roomExists(roomId)) {
            Logger.log("Room " + roomId + " does not exist.");
            return;
        }

        if (count < 0) {
            Logger.log("Invalid number of occupants.");
            return;
        }

        this.occupants = count;
        if (occupants >= 2) {
            airConditioning.update(true);
            Logger.log("Room " + roomId + " is now occupied by " + occupants + " persons. AC and lights turned on.");
            if (timer != null) {
                timer.cancel();
            }
        } else {
            airConditioning.update(false);
            Logger.log("Room " + roomId + " occupancy insufficient to mark as occupied.");
            autoReleaseBookingAfterDelay();
        }
    }

    private void autoReleaseBookingAfterDelay() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (occupants == 0) {
                    OfficeConfiguration.getInstance().setRoomBookingStatus(roomId, false);
                    Logger.log("Room " + roomId + " is now unoccupied. Booking released. AC and lights off.");
                }
            }
        }, 5 * 60 * 1000); 
    }
}
