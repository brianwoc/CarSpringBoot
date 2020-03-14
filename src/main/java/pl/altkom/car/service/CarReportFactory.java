package pl.altkom.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.model.Report.CarReport;
import pl.altkom.car.model.Report.CarReportModel;
import pl.altkom.car.repository.CarRepositoryJpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarReportFactory {

    @Autowired
    private CarRepositoryJpa dao;

    public CarReport createReport(final Integer reportType, CarReportModel carReportModel) {

        CarReport result = null;
        switch (reportType) {
            case 1: {
                //1. Pojazdy określonej marki
                result = new CarReport("Pojazdy marki BMW", dao.getAllByBrand("BMW"));
                break;
            }

            case 2: {
                //2. Pojazdy starsze niż 10 lat
                result = new CarReport("Pojazdy starsze niż 10 lat", dao.getAllByDateBefore(LocalDate.of(2010, 2, 8)));
                break;
            }

            case 3: {
                //3. Pojazdy innej marki niż Volkswagen, Audi, Skoda, Seat
                List<String> lista = new ArrayList<>();
                lista.add("Volkswagen");
                lista.add("Audi");
                lista.add("Skoda");
                lista.add("Seat");
                result = new CarReport("Pojazdy innej marki niż Volkswagen, Audi, Skoda, Seat", dao.getAllByBrandNotIn(lista));
                break;
            }
            case 4: {
                //4. Pojazdy marki Ferrari w kolorze czerwonym
                result = new CarReport("Pojazdy marki Ferrari w kolorze czerwonym", dao.getAllByBrandAndColor("Ferrari", Color.RED));
                break;
            }
            case 5: {
                //5. Pojazdy marki Ford posortowane od najnowszego
                result = new CarReport("Pojazdy marki Ford posortowane od najnowszego", dao.getAllByBrandOrderByDateDesc("Ford"));
                break;
            }
            case 6: {
                //6. Pojazdy marki Peugeot w kolorze innym niż srebrny
                result = new CarReport("Pojazdy marki Peugeot w kolorze innym niż srebrny", dao.getAllByBrandAndColorNotLike("Peugeot", Color.SILVER));
                break;
            }
            case 7: {
                //7. Pojazdy o określonej marce, modelu i kolorze - wybór przez formularz
                result = new CarReport("Pojazdy o określonej marce, modelu i kolorze - wybór przez formularz", dao.getAllByBrandAndModelAndColor(carReportModel.getBrand(), carReportModel.getModel(), carReportModel.getColor()));
                break;
            }


            default: {
                throw new UnsupportedOperationException("Nieznane rodzaj raportu");

            }
        }

        return result;

    }


}
