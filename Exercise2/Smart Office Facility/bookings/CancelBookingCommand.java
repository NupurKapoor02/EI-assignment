package bookings;

import config.OfficeConfiguration;
import utils.Logger;

public class CancelBookingCommand implements BookingCommand {
    private int roomId;

    public CancelBookingCommand(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        OfficeConfiguration config = OfficeConfiguration.getInstance();
        if (!config.roomExists(roomId)) {
            Logger.log("Room " + roomId + " does not exist.");
            return;
        }

        if (!config.isRoomBooked(roomId)) {
            Logger.log("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }

        config.setRoomBookingStatus(roomId, false);
        Logger.log("Booking for Room " + roomId + " cancelled successfully.");
    }
}
