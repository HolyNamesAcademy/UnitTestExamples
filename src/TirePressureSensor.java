public class TirePressureSensor {

    private int minPressureAllowed;
    private int maxPressureAllowed;
    private int currentPressure;
    private String wheelLabel;

    public TirePressureSensor(String wheelLabel, int currentPressure, int minPressureAllowed, int maxPressureAllowed) {
        this.wheelLabel = wheelLabel;
        this.currentPressure = currentPressure;
        this.minPressureAllowed = minPressureAllowed;
        this.maxPressureAllowed = maxPressureAllowed;
    }

    /**
     * Checks if the current pressure in the tire is within the safe range.
     */
    public boolean PressureIsSafe() {
        return this.minPressureAllowed <= this.currentPressure && this.currentPressure <= this.maxPressureAllowed;
    }

    public String GetWheelLabel() {
        return this.wheelLabel;
    }
}
