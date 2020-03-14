package pl.altkom.car.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.altkom.car.model.JSON.Example;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testApiService() throws Exception {

        Example example = apiService.getExample("50.2737939","18.8593193", "50.277304", "18.6807052");
        System.out.println(example.getPaths().get(0).getDistance());
        System.out.println(example.getPaths().get(0).getTime()/1000/60);
        Assertions.assertEquals(16259.579,example.getPaths().get(0).getDistance());
    }




}