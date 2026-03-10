
package com.example.meeting.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rooms")
public class Room {

 @Id
 @Schema(hidden = true)
 private String id;
 private String roomId;
 private int capacity;

 public Room(){}

 public Room(String roomId,int capacity){
  this.roomId=roomId;
  this.capacity=capacity;
 }

 public String getId(){return id;}
 public String getRoomId(){return roomId;}
 public int getCapacity(){return capacity;}

 public void setId(String id){this.id=id;}
 public void setRoomId(String roomId){this.roomId=roomId;}
 public void setCapacity(int capacity){this.capacity=capacity;}
}
