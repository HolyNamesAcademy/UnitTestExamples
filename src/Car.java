public class Car {

    private SafetySystem safetySystem;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.safetySystem = new SafetySystem(engine);
    }

    public void GetStatusReport() {
        String engineStatus = this.engine.EngineIsOn() ? "on." : "off.";
        System.out.println("Car is " + engineStatus);

        String report = this.safetySystem.CarIsSafeToDrive().GetReportSummary();
        System.out.println(report);
    }

    public void Refuel() {
        this.engine.FillTank();
    }
}
