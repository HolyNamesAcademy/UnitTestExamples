public class SafetyReport {

    private String message;
    private boolean isSafe;

    public static SafetyReport CreateSafeReport() {
        return new SafetyReport(true, null);
    }

    public static SafetyReport CreateUnsafeReport(String message) {
        return new SafetyReport(false, message);
    }

    private SafetyReport(boolean isSafe, String message) {
        this.isSafe = isSafe;
        this.message = message;
    }

    public boolean IsSafe() {
        return this.isSafe;
    }

    public String GetReportSummary() {
        if (this.isSafe) {
            return "The car is safe to drive.";
        }

        return "The car is not currently safe to drive. Reason: " + this.message;
    }
}
