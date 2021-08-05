package Constants;

public enum LocationCountry {
    UKRAINE("Ukraine"),
    BELARUS("Belarus"),
    MULTI_LOCATION("Multi-location");

    private String value;

    private LocationCountry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
