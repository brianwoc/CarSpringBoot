package pl.altkom.car.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private Long totalDistance=0L;

    //CONSTRUCTORS########################################################
    public Driver() {
    }


    public Driver(String firstName, String lastName, Long totalDistance) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.totalDistance = totalDistance;
    }

    //GETTERS & SETTERS #############################################################
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Long getTotalDistance() {return totalDistance;}

    public void setTotalDistance(Long totalDistance) {this.totalDistance = totalDistance;}




    //METHODS ###################################################################

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", routes=" + routes +
                ", totalDistance=" + totalDistance +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public void addRouteToDriver(final Route route) {

        this.routes.add(route);
    }
}
