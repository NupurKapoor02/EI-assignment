## Exercise 2: Problem Statements for Mini-projects

### 2. Smart Office Facility Programming Exercise

#### Problem Statement
Design a console-based application to manage a smart office facility. The system should handle conference room bookings, occupancy detection, and automate the control of air conditioning and lighting based on room occupancy. This exercise aims to evaluate the candidate's ability to implement best coding practices, design patterns, and create an efficient, maintainable, and scalable solution.

#### Features:
**Office Configuration:** Users can specify the number of available meeting rooms.

**Room Booking and Cancellation:** Users can book and cancel bookings for conference rooms.

**Occupancy Detection:** Sensors detect when at least two people enter a room.

**Booking Release:** Automatically release room bookings if not occupied within 5 minutes.

**Energy Efficiency:** Automatically turn off the air conditioning and lights when rooms are not occupied.

#### Key Components:
**SmartOfficeApplication:** Manages global state, including the list of rooms and bookings.

**OccupanySensor:** Sensors subscribe to room status changes and control lighting and air conditioning accordingly.

**Command Classes:** BookingCommand, CancelBookingCommand encapsulate actions to manage room bookings and statuses.

**Logging:** Proper logging is implemented to track room bookings, cancellations, occupancy detections, and system actions (like turning on/off lights and AC).

**Exception Handling:** Robust exception handling ensures that invalid inputs or errors are managed gracefully, providing clear feedback to the user.

**Defensive Programming:** The system has been designed to anticipate potential misuse (like booking an already occupied room or attempting to cancel a non-existent booking) and respond with appropriate safeguards.
