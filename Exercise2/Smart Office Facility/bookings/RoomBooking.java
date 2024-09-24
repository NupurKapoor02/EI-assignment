package bookings;

import config.OfficeConfiguration;
import utils.Logger;
import java.time.LocalTime;

public class RoomBooking implements BookingCommand {
    private int roomId;
    private LocalTime startTime;
    private int duration;

    public RoomBooking(int roomId, LocalTime startTime, int duration) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        OfficeConfiguration config = OfficeConfiguration.getInstance();
        if (!config.roomExists(roomId)) {
            Logger.log("Room " + roomId + " does not exist.");
            return;
        }

        if (config.isRoomBooked(roomId)) {
            Logger.log("Room " + roomId + " is already booked during this time. Cannot book.");
            return;
        }

        config.setRoomBookingStatus(roomId, true);
        Logger.log("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes.");
    }
}
