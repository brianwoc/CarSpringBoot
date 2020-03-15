package pl.altkom.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Enums.Color;

import java.time.LocalDate;
import java.util.List;

public interface CarRepositoryJpa extends JpaRepository<Car,Long> {
    List<Car> getAllByBrand(String brand);
    List<Car> getAllByDateBefore(LocalDate date);
    List<Car> getAllByBrandNotIn(List<String> lista);
    List<Car> getAllByBrandAndColor (String brand, Color color);
    List<Car>  getAllByBrandOrderByDateDesc(String brand);
    List <Car> getAllByBrandAndColorNotLike(String brand, Color color);
    List <Car> getAllByBrandAndModelAndColor(String brand, String Model, Color Color);
}
