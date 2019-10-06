public class Car {

    private SafetySystem safetySystem;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.safetySystem = new SafetySystem(engine);
    }

    public void GetStatusReport() {
        String engineStatus = this.engine.EngineIsOn() ? "ON" : "OFF";
        System.out.println("Engine: " + engineStatus);
        System.out.println(this.engine.FuelRemaining() + " gallons of fuel remaining.");

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

    public void Refuel() {
        this.engine.FillTank();
    }
}
