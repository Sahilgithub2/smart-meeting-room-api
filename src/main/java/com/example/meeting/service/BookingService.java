
package com.example.meeting.service;

import com.example.meeting.model.Booking;
import com.example.meeting.model.Room;
import com.example.meeting.repository.BookingRepository;
import com.example.meeting.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class BookingService {

 private final BookingRepository bookingRepository;
 private final RoomRepository roomRepository;

 public BookingService(BookingRepository bookingRepository,RoomRepository roomRepository){
  this.bookingRepository=bookingRepository;
  this.roomRepository=roomRepository;
 }

 public Room addRoom(Room room){
  return roomRepository.save(room);
 }

 public List<Booking> getBookings(){
  return bookingRepository.findAll();
 }

 public Map<String,Object> bookRoom(String roomId,String employee,LocalTime start,LocalTime end){

  List<Booking> existing=bookingRepository.findByRoomId(roomId);

  for(Booking b:existing){
   if(b.getStartTime().isBefore(end) && start.isBefore(b.getEndTime())){
    Map<String,Object> response=new HashMap<>();
    response.put("message","Room unavailable");
    return response;
   }
  }

  Booking booking=new Booking(roomId,employee,start,end);
  bookingRepository.save(booking);

  Map<String,Object> response=new HashMap<>();
  response.put("message","Booking successful");
  return response;
 }

 public void cancelBooking(String id){
  bookingRepository.deleteById(id);
 }
}
