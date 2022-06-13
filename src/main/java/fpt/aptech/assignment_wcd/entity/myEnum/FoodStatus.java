package fpt.aptech.assignment_wcd.entity.myEnum;

public enum FoodStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);
    private int value;
    FoodStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FoodStatus of(int value) {
        for (FoodStatus accountStatus :
                FoodStatus.values()) {
            if (accountStatus.getValue() == value) {
                return accountStatus;
            }
        }
        return FoodStatus.UNDEFINED;
    }
}
