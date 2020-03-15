package pl.altkom.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.altkom.car.controller.exception.DriverNotFoundException;
import pl.altkom.car.model.Driver;
import pl.altkom.car.repository.DriverRepositoryJpa;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    @Autowired
    private DriverRepositoryJpa driverDao;

    @GetMapping(path = "/drivers")
    public List<Driver> findAll(){
        return driverDao.findAll();
    }

    @GetMapping(path = "/drivers/{id}")
    public Driver oneDriver(@PathVariable ("id") Long id){

        try {
            Driver driver = driverDao.findById(id).get();
            return driver;
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    return null;
    }

    @DeleteMapping("/drivers/{driverId}")
    public String deleteDriver(@PathVariable Long driverId) {


        Driver driver = driverDao.findById(driverId).orElseThrow(
                ()->new DriverNotFoundException("There is no Driver with that ID"));

        driverDao.delete(driver);
        return "Driver was delete";
    }

    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver) {
        driver.setId(0L);
        driverDao.save(driver);
        return driver;
    }

    @PutMapping("/drivers")
    public Driver updateDriver(@RequestBody Driver driver) {
        driverDao.save(driver);
        return driver;
    }



}
