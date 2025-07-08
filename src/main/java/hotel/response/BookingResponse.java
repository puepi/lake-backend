package hotel.response;

import hotel.model.Room;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Long id;
    private LocalDate checkedInDate;
    private LocalDate checkedOutDate;
    private String guestFullName;
    private String guestEmail;
    private int numberOfAdults;
    private int numberOfChildren;
    private int totalNumberOfGuests;
    private String confirmationCode;
    private RoomResponse room;

    public BookingResponse(Long id, LocalDate checkedInDate, LocalDate checkedOutDate, String confirmationCode) {
        this.id = id;
        this.checkedInDate = checkedInDate;
        this.checkedOutDate = checkedOutDate;
        this.confirmationCode = confirmationCode;
    }
}
