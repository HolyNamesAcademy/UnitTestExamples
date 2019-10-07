public class Car {

    private SafetySystem safetySystem;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.safetySystem = new SafetySystem(engine);
    }

    public Engine GetEngine() {
        return this.engine;
    }

    public SafetySystem GetSafetySystem() {
        return this.safetySystem;
    }

    public void GetStatusReport() {
        String engineStatus = this.engine.EngineIsOn() ? "ON" : "OFF";
        System.out.println("Engine: " + engineStatus);
        System.out.println(String.format("%.2f gallons of fuel remaining.", this.engine.FuelRemaining()));

        String report = this.safetySystem.GetCurrentSafetyReport().GetReportSummary();
        System.out.println(report);
    }

    public void Start() {
        if (this.engine.EngineIsOn()) {
            System.out.println("Engine is already on.");
        } else {
            this.engine.StartEngine();
            System.out.println("Started the car.");
        }
    }

    public void Stop() {
        if (!this.engine.EngineIsOn()) {
            System.out.println("Engine is already off.");
        } else {
            this.engine.StopEngine();
            System.out.println("Stopped the car.");
        }
    }

    /**
     * Drive the car the specified distance.
     *
     * @param milesToTravel How far to drive the car.
     * @return true if the car can be driven the specified distance, false otherwise.
     */
    public boolean Drive(double milesToTravel) {
        SafetyReport safetyReport = this.safetySystem.GetCurrentSafetyReport();
        if (!safetyReport.IsSafe()) {
            System.out.println(safetyReport.GetReportSummary());
            return false;
        }

        if (!this.engine.EngineIsOn()) {
            System.out.println("The engine is off. You must first start the car.");
            return false;
        }

        if (this.engine.GetRangeRemaining() < milesToTravel) {
            System.out.println("Not enough fuel to drive " + milesToTravel + " miles.");
            return false;
        }

        double fuelUsed = this.engine.Drive(milesToTravel);
        System.out.println(String.format("Drove %.2f miles and used %.2f gallons of fuel.", milesToTravel, fuelUsed));

        return true;
    }
}
