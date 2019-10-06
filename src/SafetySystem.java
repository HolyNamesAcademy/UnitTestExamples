import java.util.ArrayList;

public class SafetySystem {

    private final double FuelThreshold = 0.1;

    private ArrayList<TirePressureSensor> tirePressureSensors;
    private ArrayList<Airbag> airbags;
    private Engine engine;

    public SafetySystem(Engine engine) {
        this.engine = engine;

        this.tirePressureSensors = new ArrayList<>();
        this.tirePressureSensors.add(new TirePressureSensor("front driver side", 30, 26, 34));
        this.tirePressureSensors.add(new TirePressureSensor("front passenger side", 30, 26, 34));
        this.tirePressureSensors.add(new TirePressureSensor("rear driver side", 30, 28, 36));
        this.tirePressureSensors.add(new TirePressureSensor("rear passenger side", 30, 28, 36));

        this.airbags = new ArrayList<>();
        this.airbags.add(new Airbag(40, "Driver"));
        this.airbags.add(new Airbag(40, "Passenger"));
    }

    /**
     * Simulate a collision.
     *
     * @param forceEncountered The force encountered during a collision, im Newtons.
     */
    public void Crash(double forceEncountered) {
        for (Airbag airbag : this.airbags) {
            if (airbag.ShouldDeploy(forceEncountered) && !airbag.AirbagIsDeployed()) {
                airbag.DeployAirbag();
            }
        }
    }

    /**
     * Checks if the car is safe to drive, based on the current status of all safety features of the car.
     *
     * @return A report on the current safety status of the car.
     */
    public SafetyReport GetCurrentSafetyReport() {
        if (this.airbags.size() == 0) {
            return SafetyReport.CreateUnsafeReport("No airbags detected.");
        }

        for (Airbag airbag : this.airbags) {
            if (airbag.AirbagIsDeployed()) {
                String message = "Airbag " + airbag.GetLabel() + " has been deployed.";
                return SafetyReport.CreateUnsafeReport(message);
            }
        }

        for (TirePressureSensor sensor : this.tirePressureSensors) {
            if (sensor.PressureIsSafe()) {
                String message = "The " + sensor.GetWheelLabel() + " tire has an unsafe pressure level.";
                return SafetyReport.CreateUnsafeReport(message);
            }
        }

        if (this.engine.FuelRemaining() < this.engine.FuelCapacity() * FuelThreshold) {
            String message = "There is less than " + FuelThreshold * 100 + "% of the engine's fuel remaining.";
            return SafetyReport.CreateUnsafeReport(message);
        }

        return SafetyReport.CreateSafeReport();
    }
}
