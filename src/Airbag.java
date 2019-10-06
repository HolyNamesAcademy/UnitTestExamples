public class Airbag {

    private double forceThreshold;
    private boolean isDeployed;
    private String label;

    public Airbag(double forceThreshold, String label) {
        this.forceThreshold = forceThreshold;
        this.label = label;
        this.isDeployed = false;
    }

    public String GetLabel() {
        return this.label;
    }

    public boolean ShouldDeploy(double forceEncountered) {
        return forceEncountered >= this.forceThreshold;
    }

    public boolean AirbagIsDeployed() {
        return this.isDeployed;
    }

    public void DeployAirbag() {
        this.isDeployed = true;
    }
}
