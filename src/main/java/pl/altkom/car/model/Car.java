package pl.altkom.car.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.altkom.car.model.Enums.Color;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
@Entity(name = "car")
public class Car {

    //FIELDS######################################################
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Pattern(regexp = "[^@ ?!\\,$%]+", message = "*{first.correctregex}")
    @Column(name = "brand")
    private String brand;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Pattern(regexp = "[^@ ?!\\,$%]+", message = "*{first.correctregex}")
    @Column(name = "model")
    private String model;

    @NotEmpty(message = "*{first.correctnull}")
    @Size(min = 2, max = 10, message = "*{first.correctlength}")
    @Pattern(regexp = "[^@ ?!\\,$%]+", message = "*{first.correctregex}")
    @Column(name = "VIN")
    private String VIN;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private List<Route> routeList = new ArrayList<>(0);

    //CONSTRUCTORS##################################################
    public Car() {
    }

    public Car(String brand, String model, String VIN, LocalDate date, Color color, long id) {
        this.brand = brand;
        this.model = model;
        this.VIN = VIN;
        this.date = date;
        this.color = color;
        this.id = id;
    }

    public Car(String brand, String model, String VIN, LocalDate date, Color color) {
        this.brand = brand;
        this.model = model;
        this.VIN = VIN;
        this.date = date;
        this.color = color;
    }

    //GETTERS&SETTERS##################################################################

    public void addRoute(final Route route){

        this.routeList.add(route);
    }
}
