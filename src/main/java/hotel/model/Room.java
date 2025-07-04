package hotel.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class Room {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String roomType;
     private BigDecimal roomPrice;
     private boolean isBooked=false;
     @OneToMany(mappedBy = "room")
     private List<Booking> bookings=new ArrayList<>();
}
