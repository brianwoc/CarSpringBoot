package pl.altkom.car.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Enums.Color;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.altkom.car.model.Enums.Color.WHITE;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CarRepositoryJpaTest {
    @Autowired
    private CarRepositoryJpa carDao;

    @BeforeEach
    void setUp() {
        Car car = new Car("BMW","A4", "2222",LocalDate.of(2005,10,9), Color.WHITE);
        carDao.save(car);
    }

    @Test
    public void FindAll_shouldReturnTwoCars() {
        List<Car> listCars = carDao.findAll();
        Assertions.assertEquals(2, listCars.size());

    }





}
