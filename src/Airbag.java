public class Airbag {

    private double forceThreshold;
    private boolean isDeployed;
    private String label;

    public Airbag(double forceThreshold, String label) {
        this.forceThreshold = forceThreshold;
        this.label = label;
        this.isDeployed = false;
    }

    /**
     * Gets the label describing which airbag this is.
     */
    public String GetLabel() {
        return this.label;
    }

    /**
     * Checks if the airbag should deploy given the force encountered during a collision.
     *
     * @param forceEncountered The force encountered during the collision, in Newtons.
     * @return true if the airbag should deploy, otherwise false.
     */
    public boolean ShouldDeploy(double forceEncountered) {
        return forceEncountered >= this.forceThreshold;
    }

    /**
     * Checks if the airbag has been deployed.
     */
    public boolean AirbagIsDeployed() {
        return this.isDeployed;
    }

    /**
     * Deploy the airbag.
     */
    public void DeployAirbag() {
        this.isDeployed = true;
    }
}
