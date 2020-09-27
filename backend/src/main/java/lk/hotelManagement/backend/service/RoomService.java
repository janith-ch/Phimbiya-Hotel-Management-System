package lk.hotelManagement.backend.service;

import lk.hotelManagement.backend.model.Room;
import lk.hotelManagement.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> rooms() {
        return roomRepository.rooms();
     }
   public boolean createRoom(Room room) {
        return roomRepository.createRoom(room);
    }
}
