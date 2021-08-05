package Constants;

public enum LocationCity {
    LVIV("Lviv");

    private String value;

    private LocationCity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
