package pl.altkom.car.model.Report;

import pl.altkom.car.model.Enums.Color;

public class CarReportModel {

    private String brand;
    private String model;
    private Color color;

    public CarReportModel(String brand, String model, Color color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public CarReportModel() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
