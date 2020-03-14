package pl.altkom.car.model.Enums;

public enum City {
    KRAKÓW("Kraków","50.0467446", "19.9348341"),
    KATOWICE("Katowice", "50.2136513","18.9371538"),
    ZABRZE("Zabrze", "50.3149193","18.7266108"),
    WARSZAWA("Szczecin","53.4296143","14.4845429" ),
    RUDA("Ruda Slaska", "50.2699996", "18.8036364"),
    SZCZECIN("Szczecin", "53.4298189", "14.4845423"),
    BIALYSTOK("Białystok", "53.1277077", "23.0860266"),
    RZESZOW("Rzeszów", "50.0055192", "21.9184156"),
    WROCLAW("Wrocław", "51.1271647", "16.9218246");

    private String name;
    private String latitude;
    private String longitude;

    City(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
