package Constants;

public enum BaseData {
    BASE_URL("https://training.by/#!/Home?lang=en"),
    EMAIL("ivanhorintest@gmail.com"),
    PASSWORD("ivanhorintestPassword");
    private String value;

    private BaseData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

