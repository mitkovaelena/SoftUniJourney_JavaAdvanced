package e01_BoatRacingSimulator.Utility;

public class Validator {
    public static void validatePropertyValue(int value, String propertyName) {
        switch (propertyName) {
            case "Efficiency":
                if (value < 1 || value > 100) {
                    throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
                }
                break;
            default:
                if (value <= 0) {
                    throw new IllegalArgumentException(String.format(Constants.INCORRECT_PROPERTY_VALUE_MESSAGE, propertyName));
                }
                break;
        }
    }

    public static void validateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.INCORRECT_MODEL_LENGHT_MESSAGE, minModelLength));
        }
    }
}
