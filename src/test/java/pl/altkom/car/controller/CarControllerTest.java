package pl.altkom.car.controller;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.altkom.car.repository.CarRepositoryJpa;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CarControllerTest {
    @Mock
    CarRepositoryJpa carDao;
    @Mock
    Model model;

    CarController controller;

    @BeforeEach
    public void  setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        controller = new CarController(carDao);
    }


    @Test
    void testPrepareAllCarView() {

        String viewName = controller.prepareAllCarView(model);
        Assertions.assertEquals("showCars", viewName);
        verify(carDao, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("cars"), anyList());

    }
}