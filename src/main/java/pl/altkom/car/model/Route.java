package pl.altkom.car.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.altkom.car.model.Enums.City;
import pl.altkom.car.model.Validation.DataValidation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@Entity(name = "route")
@EqualsAndHashCode(exclude = {"driver"})
@DataValidation
public class Route {


    // POLA ################################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Column(name = "symbol")
    private String symbol;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "start_point_adress")
    private City startPointAdress;

    @Enumerated(EnumType.STRING)
    @Column(name = "end_point_adress")
    private City endPointAdress;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "travel_time")
    private Long travelTime;

    @Column(name = "realised")
    private boolean isRealised;

//    @Column(name = "driver_id")
//    private Long driverId;

    @ManyToOne
    private Driver driver;

    //CONSTRUCTOR #################################################


    public void setTravelTime(Long travelTime) {
        double travelTimeMinute = travelTime /1000 / 60;

        this.travelTime = (long)travelTimeMinute;
    }

    public Route() {
    }


    public Route(String symbol,LocalDateTime startTime,LocalDateTime endTime,
                 City startPointAdress,City endPointAdress, Long travelTime,Long distance, boolean isRealised) {
        this.symbol = symbol;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startPointAdress = startPointAdress;
        this.endPointAdress = endPointAdress;
        this.travelTime = travelTime;
        this.distance = distance;
        this.isRealised = isRealised;
    }

//    public Long getDriverId() {
//        return driverId;
//    }
//
//    public void setDriverId(Long driverId) {
//        this.driverId = driverId;
//    }
}
