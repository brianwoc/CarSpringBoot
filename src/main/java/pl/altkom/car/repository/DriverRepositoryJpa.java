package pl.altkom.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.car.model.Driver;
import pl.altkom.car.model.Route;

@Repository
public interface DriverRepositoryJpa extends JpaRepository<Driver,Long> {


}
