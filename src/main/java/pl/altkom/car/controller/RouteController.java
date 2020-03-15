package pl.altkom.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.car.model.Car;
import pl.altkom.car.model.Driver;
import pl.altkom.car.model.Enums.City;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.model.JSON.Example;
import pl.altkom.car.model.Route;
import pl.altkom.car.repository.CarRepositoryJpa;
import pl.altkom.car.repository.DriverRepositoryJpa;
import pl.altkom.car.repository.RouteRepositoryJpa;
import pl.altkom.car.service.ApiService;

import javax.validation.Valid;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RouteController {
    @Autowired
    private ApiService apiService;

    @Autowired
    private RouteRepositoryJpa routeDao;

    @Autowired
    private DriverRepositoryJpa driverDao;

    @Autowired
    private CarRepositoryJpa carDao;


    @GetMapping(path = "/addRoute")
    public String preparedRouteForm(@RequestParam(name = "carId") Long carId,
                                    final Model model) {


        model.addAttribute("cityModel", City.values());
        model.addAttribute("route", new Route());
        model.addAttribute("carId", carId);
        return "addRoute";
    }


    @PostMapping(path = "/addRoute")
    public String processRuteForm(@RequestParam(name = "carId") Long carId,
                                  @Valid Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addRoute";
        }
        Car car = carDao.getOne(carId);
        City city1 = route.getStartPointAdress();
        City city2 = route.getEndPointAdress();


        Example example = apiService.getExample(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
        route.setDistance(example.getPaths().get(0).getDistance().longValue());
        route.setTravelTime((example.getPaths().get(0).getTime()).longValue());
        car.addRoute(route);
        carDao.save(car);

        return "redirect:/";
    }


    @GetMapping(path = "/addRouteDriver")
    public String preparedDriverRouteForm(@RequestParam(name = "driverId") Long driverId,
                                          final Model model) {

        model.addAttribute("cityModel", City.values());
        model.addAttribute("route", new Route());
        model.addAttribute("driverId", driverId);
        return "addRouteDriver";
    }


    @PostMapping(path = "/addRouteDriver")
    public String processDriverRouteForm(@RequestParam(name = "driverId") Long driverId,
                                         @Valid Route route, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addRouteDriver";
        }
        Driver driver = driverDao.getOne(driverId);

        City city1 = route.getStartPointAdress();
        City city2 = route.getEndPointAdress();

        //Feature - Counting total distance of selected driver
        Example example = apiService.getExample(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
        route.setDistance(example.getPaths().get(0).getDistance().longValue());
        route.setTravelTime(example.getPaths().get(0).getTime().longValue());

        driver.addRouteToDriver(route);
        driverDao.save(driver);
        return "redirect:/";
    }
    @GetMapping(path = "/realiseRoute")
    public String realiseRouteAndAddDistanceToDriver(@RequestParam(name = "routeId") Long routeId){
        Route route = routeDao.getOne(routeId);
        Driver driver = driverDao.getOne(route.getDriver().getId());
        Long distance = route.getDistance();
        driver.setTotalDistance(driver.getTotalDistance()+distance);
        route.setRealised(true);
        driverDao.save(driver);
        return "redirect:/";
    }



    @GetMapping(path = "/showRoutes")
    public String prepareAllRoutesView(final Model model) {

        List<Route> allRoute = routeDao.findAll();
        model.addAttribute("routes", allRoute);
        return "showRoutes";
    }

    @GetMapping("/deleteRoute")
    public String deleteRoute(@RequestParam(name = "routeId") Long routeId){


        System.out.printf("Usuniecie trasy o id = %d%n", routeId);
        routeDao.deleteById(routeId);
        return "redirect:/";
    }


    @GetMapping(path = "/addRouteEdit")
    public String preparedRouteFormEdit(Route route, @RequestParam(name = "routeId")  Long routeId,
                                     Model model) {

        model.addAttribute("cityModel", City.values());
        if (routeId!= null){
            Route foundRoute = routeDao.findById(routeId).get();
            route.setId((foundRoute.getId()));
            route.setDistance((foundRoute.getDistance()));
            route.setTravelTime((foundRoute.getTravelTime()));
            route.setRealised((foundRoute.isRealised()));
            route.setEndPointAdress((foundRoute.getEndPointAdress()));
            route.setStartPointAdress((foundRoute.getStartPointAdress()));
            route.setEndTime(foundRoute.getEndTime());
            route.setStartTime(foundRoute.getStartTime());
            route.setSymbol(foundRoute.getSymbol());

        }
        System.out.printf("Metoda GetMappingId= %s%n", routeId);


        return "addRouteEdit";
    }


    @PostMapping(path = "/addRouteEdit")
    public String processRuteFormEdit(@Valid Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addRouteEdit";
        }


        City city1 = route.getStartPointAdress();
        City city2 = route.getEndPointAdress();

        Example example = apiService.getExample(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
        route.setDistance(example.getPaths().get(0).getDistance().longValue());
        route.setTravelTime((example.getPaths().get(0).getTime()).longValue());
        routeDao.save(route);

        return "redirect:/";
    }


}
