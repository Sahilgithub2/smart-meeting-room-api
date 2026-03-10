
package com.example.meeting.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.meeting.model.Room;
import com.example.meeting.service.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Map;


@Tag(
        name = "2️⃣ Meeting Room APIs",
        description = "Step 2: After logging in and authorizing with JWT, use these APIs to manage meeting rooms and bookings."
)
@RestController
@RequestMapping("/api")
public class BookingController {

 private final BookingService service;

 public BookingController(BookingService service){
  this.service=service;
 }

    @Operation(
            summary = "Create a meeting room",
            description = """
        Creates a new meeting room.

        Example request:
        {
          "roomId": "A101",
          "capacity": 6
        }
        """
    )
    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room){
        return service.addRoom(room);
    }

    @Operation(
            summary = "Book a meeting room",
            description = """
        Books a meeting room.

        Example request:
        {
          "roomId": "A101",
          "startTime": "10:00",
          "endTime": "11:00"
        }

        The logged-in user will automatically be assigned as the employee.
        """
    )
    @PostMapping("/book")
    public Map<String,Object> bookRoom(@RequestBody Map<String,String> req,
                                       Authentication authentication){

        String username = authentication.getName();

        return service.bookRoom(
                req.get("roomId"),
                username,
                LocalTime.parse(req.get("startTime")),
                LocalTime.parse(req.get("endTime"))
        );
    }

    @Operation(
            summary = "View all bookings",
            description = "Returns all meeting bookings stored in MongoDB."
    )
    @GetMapping("/bookings")
    public Object getBookings(){
  return service.getBookings();
 }

    @Operation(
            summary="Cancel a booking",
            description="Deletes a booking using the booking ID."
    )
    @DeleteMapping("/book/{id}")
    public String cancel(@PathVariable String id){
  service.cancelBooking(id);
  return "Booking cancelled";
 }
}
