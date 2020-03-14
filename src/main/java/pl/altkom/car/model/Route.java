package pl.altkom.car.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.altkom.car.model.Enums.City;
import pl.altkom.car.model.Validation.DataValidation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Component
@Entity(name = "route")
public class Route {


    // POLA ################################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Column(name = "symbol")
    private String symbol;

    //@DataValidation
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

    //CONSTRUCTOR #################################################

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





    //GETTERS & SETERS ############################################


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public City getStartPointAdress() {
        return startPointAdress;
    }

    public void setStartPointAdress(City startPointAdress) {
        this.startPointAdress = startPointAdress;
    }

    public City getEndPointAdress() {
        return endPointAdress;
    }

    public void setEndPointAdress(City endPointAdress) {
        this.endPointAdress = endPointAdress;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Long travelTime) {
        this.travelTime = travelTime/1000/60;
    }

    public boolean isRealised() {
        return isRealised;
    }

    public void setRealised(boolean realised) {
        isRealised = realised;
    }


}
