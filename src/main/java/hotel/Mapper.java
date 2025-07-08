package hotel;

import hotel.model.Room;
import hotel.response.RoomResponse;

public class Mapper {
    public static RoomResponse RoomToRoomResponse(Room room){
        RoomResponse response=new RoomResponse();
        response.setId(room.getId());
        response.setRoomType(room.getRoomType());
        response.setRoomPrice(room.getRoomPrice());
        return response;
    }
}
