package hotel.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Base64Util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked=false;
    private String photo;
    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes, List<BookingResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64Util.encode(Arrays.toString(photoBytes)) : null;
        this.bookings = bookings;
    }
}
