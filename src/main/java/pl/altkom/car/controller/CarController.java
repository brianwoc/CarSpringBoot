package pl.altkom.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.repository.CarRepositoryJpa;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CarController {

    @GetMapping("/")
    public String showMenu(){
        return "mainM";
    }

    private CarRepositoryJpa carDao;

    @Autowired
    public CarController(CarRepositoryJpa carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/addCar")
    public String showForm(Car car, @RequestParam(name = "carId", required = false) Long carId, Model model){

        model.addAttribute( "colorModel", Color.values());

        if (carId!= null){
            Car foundCar = carDao.findById(carId).get();
            car.setId((foundCar.getId()));
            car.setBrand((foundCar.getBrand()));
            car.setColor((foundCar.getColor()));
            car.setDate((foundCar.getDate()));
            car.setModel((foundCar.getModel()));
            car.setVIN((foundCar.getVIN()));

        }
        System.out.printf("Metoda GetMappingId= %s%n", carId);


        return "addCar";
    }

    @PostMapping("/addCar")
    public String processForm(@Valid Car car,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addCar";
        }

        carDao.save(car);
        System.out.printf("%s,%s,%s,%s,%s%n",car.getVIN(),car.getBrand(),car.getModel(),car.getDate(),car.getColor());
        return "redirect:/";
    }


    @GetMapping(path = "/showCars")
    public String prepareAllCarView(final Model model) {

        List<Car> allCars = carDao.findAll();
        model.addAttribute("cars", allCars);
        return "showCars";
    }


    @GetMapping("/deleteCar")
    public String deleteCars(@RequestParam(name = "carId") Long carId){


        System.out.printf("Usuniecie osoby o id = %d%n", carId);
        carDao.deleteById(carId);
        return "redirect:/";
    }

}
