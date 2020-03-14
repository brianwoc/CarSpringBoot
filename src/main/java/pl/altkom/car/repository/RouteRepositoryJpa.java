package pl.altkom.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Route;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RouteRepositoryJpa extends JpaRepository<Route,Long> {


}
