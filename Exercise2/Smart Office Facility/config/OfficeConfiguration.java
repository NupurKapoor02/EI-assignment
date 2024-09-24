package config;

import utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, Integer> roomCapacities;
    private Map<Integer, Boolean> roomBookingStatus;

    private OfficeConfiguration() {
        roomCapacities = new HashMap<>();
        roomBookingStatus = new HashMap<>();
    }

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRoom(int roomId, int capacity) {
        if (capacity <= 0) {
            Logger.log("Invalid capacity. Please enter a valid positive number.");
            return;
        }
        roomCapacities.put(roomId, capacity);
        roomBookingStatus.put(roomId, false);  
        Logger.log("Room " + roomId + " maximum capacity set to " + capacity);
    }

    public boolean roomExists(int roomId) {
        return roomCapacities.containsKey(roomId);
    }

    public int getRoomCapacity(int roomId) {
        return roomCapacities.getOrDefault(roomId, -1);
    }

    public boolean isRoomBooked(int roomId) {
        return roomBookingStatus.getOrDefault(roomId, false);
    }

    public void setRoomBookingStatus(int roomId, boolean status) {
        roomBookingStatus.put(roomId, status);
    }
}
