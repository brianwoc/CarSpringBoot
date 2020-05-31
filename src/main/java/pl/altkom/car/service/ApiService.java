package pl.altkom.car.service;

import pl.altkom.car.model.JSON.Example;


public interface ApiService {

    Example getExample(String startLatitude, String startLongtitude, String endLatitude, String endLongtitude);

}
