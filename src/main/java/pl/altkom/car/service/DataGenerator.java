package pl.altkom.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Enums.City;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.model.Driver;
import pl.altkom.car.model.Route;
import pl.altkom.car.repository.CarRepositoryJpa;
import pl.altkom.car.repository.DriverRepositoryJpa;
import pl.altkom.car.repository.RouteRepositoryJpa;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DataGenerator {
    @Autowired
    private DriverRepositoryJpa driverDao;
    @Autowired
    private CarRepositoryJpa carDao;
    @Autowired
    private RouteRepositoryJpa routeDao;

    @PostConstruct
    public void createSomeData(){
        carDao.save(new Car("BMW","A4", "1111", LocalDate.of(2000,10,9), Color.WHITE));
        carDao.save(new Car("BMW","A4", "2222", LocalDate.of(2005,10,9), Color.WHITE));
        carDao.save(new Car("Ford","M1", "2222", LocalDate.of(2015,01,12), Color.BLACK));
        carDao.save(new Car("Volvo","V5", "44444", LocalDate.of(2000,10,9), Color.RED));
        carDao.save(new Car("Ford","A3", "555", LocalDate.of(2000,10,9), Color.BLUE));
        carDao.save(new Car("Peugeot","126P", "11342", LocalDate.of(1988,10,9), Color.SILVER));
        carDao.save(new Car("Peugeot","126P", "11342", LocalDate.of(1988,10,9), Color.WHITE));
        carDao.save(new Car("Ferrari","A5", "1134211", LocalDate.of(1988,10,9), Color.RED));
        carDao.save(new Car("Ferrari","A5", "1134211", LocalDate.of(1988,10,9), Color.WHITE));
        carDao.save(new Car("Ford","dd3", "555", LocalDate.of(2020,10,9), Color.BLUE));


        driverDao.save(new Driver("Jan", "Kowalski", 0L));
        driverDao.save(new Driver("Marek", "Nowak",0L));
        driverDao.save(new Driver("Ola", "Król",0L));
        driverDao.save(new Driver("Magda", "Kowalski",0L));
        Driver driver1 = new Driver("Iza", "Nowak",0L);
        driver1.addRouteToDriver(new Route("KR-KAT", LocalDateTime.of(2020,04,19,8,54), LocalDateTime.of(2020,04,20,8,54), City.KRAKÓW, City.KATOWICE, 432552L, 79000L, false));
        driverDao.save(driver1);

    }


}
