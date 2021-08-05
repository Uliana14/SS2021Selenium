package Constants;

public enum LinksTitles {
    NEWS("NEWS"),
    REAL_STORIES("REAL STORIES"),
    MATERIALS("MATERIALS"),
    HARD_SKILLS("HARD SKILLS"),
    SOFT_SKILLS("SOFT SKILLS"),
    EVENTS("EVENTS");

    private String value;

    private LinksTitles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
