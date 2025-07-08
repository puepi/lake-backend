package hotel.controller;

import hotel.ApiResponse;
import hotel.Mapper;
import hotel.model.Room;
import hotel.response.RoomResponse;
import hotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping(value="/rooms")
@RequiredArgsConstructor
public class RoomController {
    public final IRoomService roomService;

    @PostMapping(value="/add")
    public ResponseEntity<ApiResponse> addNewRoom(@RequestParam MultipartFile file,@RequestParam String roomType,@RequestParam BigDecimal roomPrice){
        Room savedRoom;
        try {
            savedRoom = roomService.addNewRoom(file,roomType,roomPrice);
            RoomResponse response= Mapper.RoomToRoomResponse(savedRoom);
            return ResponseEntity.ok(new ApiResponse("Success",response));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
    @GetMapping()
    public ResponseEntity<ApiResponse> getRoom(){
//        Room savedRoom;
        try {
//            savedRoom = roomService.addNewRoom(file,roomType,roomPrice);
//            RoomResponse response= Mapper.RoomToRoomResponse(savedRoom);
            return ResponseEntity.ok(new ApiResponse("Success","response"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
