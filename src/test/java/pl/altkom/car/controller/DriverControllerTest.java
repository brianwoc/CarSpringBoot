package pl.altkom.car.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import pl.altkom.car.model.Driver;
import pl.altkom.car.repository.DriverRepositoryJpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DriverControllerTest {
    @Mock
    DriverRepositoryJpa driverDao;

    @Mock
    Model model;

    @Mock
    Driver driver;

    DriverController driverController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        driverController = new DriverController(driverDao);
    }

    @Test
    void testPrepareAllDriversView() {
        String viewString = driverController.prepareAllDriversView(model);
        Assertions.assertEquals("showDriver", viewString);
        verify(model,times(1)).addAttribute(eq("drivers"),anyList());
        verify(driverDao,times(1)).findAll();
    }


}