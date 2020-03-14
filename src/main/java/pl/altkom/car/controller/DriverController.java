package pl.altkom.car.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Driver;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.model.Route;
import pl.altkom.car.repository.CarRepositoryJpa;
import pl.altkom.car.repository.DriverRepositoryJpa;
import pl.altkom.car.repository.RouteRepositoryJpa;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private RouteRepositoryJpa routeDao;

    @Autowired
    private DriverRepositoryJpa driverDao;

    @Autowired
    private CarRepositoryJpa carDao;

    @GetMapping(path = "/showDriver")
    public String prepareAllDriversView(final Model model) {

        List<Driver> allDrivers = driverDao.findAll();

        System.out.println(allDrivers);
        model.addAttribute("drivers", allDrivers);
        return "showDriver";


    }



    @GetMapping("/addDriver")
    public String showForm(Driver driver, @RequestParam(name = "driverId", required = false) Long driverId, Model model){


        if (driverId!= null){
            Driver foundDriver = driverDao.findById(driverId).get();
            driver.setId((foundDriver.getId()));
            driver.setFirstName((foundDriver.getFirstName()));
            driver.setLastName((foundDriver.getLastName()));
        }
        System.out.printf("Metoda GetMappingId= %s%n", driverId);
        return "addDriver";
    }

    @PostMapping("/addDriver")
    public String processForm(@Valid Driver driver,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addDriver";
        }

        driverDao.save(driver);
        System.out.printf("%s,%s%n",driver.getFirstName(),driver.getLastName());
        return "redirect:/";
    }

    @GetMapping("/deleteDriver")
    public String deleteCars(@RequestParam(name = "driverId") Long driverId){
        System.out.printf("Usuniecie kierowcy o id = %d%n", driverId);
        driverDao.deleteById(driverId);
        return "redirect:/";
    }




}