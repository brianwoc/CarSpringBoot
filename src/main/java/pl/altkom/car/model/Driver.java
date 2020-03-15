package pl.altkom.car.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity(name = "driver")
public class Driver {

    //FIELDS##########################################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Column(name = "first_name")
    private String firstName;


    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Column(name = "last_name")
    private String lastName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private List<Route> routes = new ArrayList<>(0);

    private Long totalDistance;

    //CONSTRUCTORS########################################################
    public Driver() {
        this.totalDistance =0L;
    }


    public Driver(String firstName, String lastName, Long totalDistance) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.totalDistance = totalDistance;
    }


    //METHODS ###################################################################


    public void addRouteToDriver(final Route route) {

        this.routes.add(route);
    }
}
