public class Engine {

    private double mpg;
    private double fuelCapacity;
    private double gallonsOfFuelRemaining;
    private boolean engineIsOn;

    public Engine(double fuelCapacity, double gallonsOfFuelRemaining, double mpg) {
        this.fuelCapacity = fuelCapacity;
        this.gallonsOfFuelRemaining = gallonsOfFuelRemaining;
        this.mpg = mpg;
        this.engineIsOn = false;
    }

    /**
     * Checks if the engine is currently turned on.
     *
     * @return true if the engine is on, otherwise false.
     */
    public boolean EngineIsOn() {
        return this.engineIsOn;
    }

    /**
     * Starts the engine.
     */
    public void StartEngine() {
        this.engineIsOn = true;
    }

    /**
     * Stops the engine.
     */
    public void StopEngine() {
        this.engineIsOn = false;
    }

    /**
     * Gets the amount of fuel remaining in the tank, in gallons.
     */
    public double FuelRemaining() {
        return this.gallonsOfFuelRemaining;
    }

    /**
     * Gets the total amount of fuel the car can hold, im gallons.
     */
    public double FuelCapacity() {
        return this.fuelCapacity;
    }

    /**
     * Fills the gas tank to its full capacity.
     *
     * @return The amount of fuel added to the tank in order to fill it, in gallons.
     */
    public double FillTank() {
        double refillAmount = this.fuelCapacity - this.gallonsOfFuelRemaining;
        this.gallonsOfFuelRemaining = this.fuelCapacity;

        return refillAmount;
    }

    public double GetRangeRemaining() {
        return this.gallonsOfFuelRemaining * this.mpg;
    }

    /**
     * Drive the car the specified distance and reduce the amount of fuel in the tank according to the engine's MPG rating.
     *
     * @param milesToTravel The distance to drive the car.
     * @return The amount of fuel consumed to make the trip.
     */
    public double Drive(double milesToTravel) {
        double fuelUsed = milesToTravel / this.mpg;

        if (fuelUsed > this.gallonsOfFuelRemaining) {
            fuelUsed = this.gallonsOfFuelRemaining;
        }

        this.gallonsOfFuelRemaining -= fuelUsed;

        return fuelUsed;
    }
}
