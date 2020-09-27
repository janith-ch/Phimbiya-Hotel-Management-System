package lk.hotelManagement.backend.controller;

import lk.hotelManagement.backend.model.Room;

import lk.hotelManagement.backend.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/")
    public List<Room> rooms() {
        return roomService.rooms();
    }

    @PostMapping("/")
    public boolean createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }
}

