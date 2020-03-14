package pl.altkom.car.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.altkom.car.model.JSON.Example;

@Service
public class ApiServiceImpl implements ApiService {


    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Example getExample(String startLatitude, String startLongtitude, String endLatitude, String endLongtitude) {
        String startPoint = startLatitude  +","  +startLongtitude ;
        String endPoint =  endLatitude +"," + endLongtitude;

        Example example = restTemplate.getForObject("https://graphhopper.com/api/1/route?point="+startPoint+"," + "&point=" +
                endPoint+"&vehicle=car&debug=true&key=d714c9b8-cb04-476b-bacc-a88cc6163ce1&type=json&calc_points=false&instructions=false", Example.class);
        return example;
    }

}
