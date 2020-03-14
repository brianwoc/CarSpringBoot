package pl.altkom.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.altkom.car.model.Enums.Color;
import pl.altkom.car.model.Report.CarReport;
import pl.altkom.car.model.Report.CarReportModel;
import pl.altkom.car.service.CarReportFactory;

@Controller
public class CarReportController {
    @Autowired
    private CarReportFactory reportFactory;
    @GetMapping("/carReport")
    public String processReportRequest(final Model model, @RequestParam("reportId") Integer reportId){
        CarReport report = reportFactory.createReport(reportId, null);
        model.addAttribute("reportData", report);

        return "report";
    }

    @GetMapping("/carReportForm")
    public String processToFormReport(CarReportModel carReportModel, final Model model){
        model.addAttribute( "colorModel", Color.values());

        return "carReportForm";
    }

    @PostMapping("/carReportForm")
    public String processReportRequestedData(final Model model, CarReportModel carReportModel ){

        CarReport report = reportFactory.createReport(7, carReportModel);
        model.addAttribute("reportData", report);

        return "report";
    }


}
