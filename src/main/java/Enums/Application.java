package Enums;

public enum Application {
    Desktop( 0),
    Mobile(1);

    public final Integer value;

    private Application(Integer value) {
        this.value = value;
    }
}
