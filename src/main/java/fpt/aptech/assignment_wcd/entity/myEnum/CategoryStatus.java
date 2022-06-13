package fpt.aptech.assignment_wcd.entity.myEnum;

public enum CategoryStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(2);
    private int value;
    CategoryStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CategoryStatus of(int value) {
        for (CategoryStatus productStatus : CategoryStatus.values()) {
            if(productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return CategoryStatus.UNDEFINED;
    }
}
