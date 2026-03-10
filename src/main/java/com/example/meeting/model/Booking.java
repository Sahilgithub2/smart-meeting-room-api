
package com.example.meeting.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalTime;

@Document(collection="bookings")
public class Booking {

 @Id
 @Schema(hidden = true)
 private String id;
 private String roomId;
 private String employee;
 private LocalTime startTime;
 private LocalTime endTime;

 public Booking(){}

 public Booking(String roomId,String employee,LocalTime startTime,LocalTime endTime){
  this.roomId=roomId;
  this.employee=employee;
  this.startTime=startTime;
  this.endTime=endTime;
 }

 public String getId(){return id;}
 public String getRoomId(){return roomId;}
 public String getEmployee(){return employee;}
 public LocalTime getStartTime(){return startTime;}
 public LocalTime getEndTime(){return endTime;}

 public void setId(String id){this.id=id;}
 public void setRoomId(String roomId){this.roomId=roomId;}
 public void setEmployee(String employee){this.employee=employee;}
 public void setStartTime(LocalTime startTime){this.startTime=startTime;}
 public void setEndTime(LocalTime endTime){this.endTime=endTime;}
}
