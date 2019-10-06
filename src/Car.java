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

    public void Refuel() {
        this.engine.FillTank();
    }
}
