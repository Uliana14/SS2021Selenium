package Constants;

public enum CourseTitles {
    JAVA("Java"),
    RUBY("Ruby");

    private String value;

    private CourseTitles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
