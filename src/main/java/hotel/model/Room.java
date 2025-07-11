package hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Room {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String roomType;
     private BigDecimal roomPrice;
     private boolean isBooked=false;
     @Lob
     private Blob photo;
     @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<Booking> bookings=new ArrayList<>();

     public void addBooking(Booking booking){
          bookings.add(booking);
          booking.setRoom(this);
          isBooked=true;
          String bookingCode= RandomStringUtils.randomNumeric(10);
          booking.setConfirmationCode(bookingCode);
     }
}
