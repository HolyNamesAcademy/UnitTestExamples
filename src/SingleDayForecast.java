
public class SingleDayForecast {
    private int highTemperature;
    private int lowTemperature;
    private int percentChanceRain;
    private String outlook;

    public SingleDayForecast(int highTemperature, int lowTemperature, int percentChanceRain, String outlook) {
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.percentChanceRain = percentChanceRain;
        this.outlook = outlook;
    }

    public int getHighTemperature() {
        return this.highTemperature;
    }

    public int getLowTemperature() {
        return this.lowTemperature;
    }

    public int getPercentChanceRain() {
        return this.percentChanceRain;
    }

    public String getOutlook() {
        return this.outlook;
    }
}
