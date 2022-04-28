package domain;

public enum Size {

    FAMILY(1.8), DOUBLE(2), PERSONAL(1);

    private final double doubleData;
    private String stringData;

    Size(double doubleData) {
        this.doubleData = doubleData;
    }

//    Size(String stringData) {
//        this.stringData = stringData;
//    }

    public double getDoubleDataData() {
        return doubleData;
    }

//    public String getData() {
//        return stringData;
//    }
}
