
package com.example.meeting.repository;

import com.example.meeting.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room,String> {
 Optional<Room> findByRoomId(String roomId);
}
