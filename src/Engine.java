public class Engine {

    private double mpg;
    private double fuelCapacity;
    private double gallonsOfFuelRemaining;
    private boolean engineIsOn;

    private Engine(double fuelCapacity, double gallonsOfFuelRemaining, double mpg) {
        this.fuelCapacity = fuelCapacity;
        this.gallonsOfFuelRemaining = gallonsOfFuelRemaining;
        this.mpg = mpg;
        this.engineIsOn = false;
    }

    public boolean EngineIsOn() {
        return this.engineIsOn;
    }

    public void StartEngine() {
        this.engineIsOn = true;
    }

    public void StopEngine() {
        this.engineIsOn = false;
    }

    public double FuelRemaining() {
        return this.gallonsOfFuelRemaining;
    }

    public double FuelCapacity() {
        return this.fuelCapacity;
    }

    public double FillTank() {
        double refillAmount = this.fuelCapacity - this.gallonsOfFuelRemaining;
        this.gallonsOfFuelRemaining = this.fuelCapacity;

        return refillAmount;
    }

    public double Drive(double milesToTravel) {
        double fuelUsed = milesToTravel / mpg;

        if (fuelUsed > this.gallonsOfFuelRemaining) {
            fuelUsed = this.gallonsOfFuelRemaining;
        }

        this.gallonsOfFuelRemaining -= fuelUsed;

        return fuelUsed;
    }
}
