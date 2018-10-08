import java.util.ArrayList;

public class MultiDayForecast {
    private ArrayList<SingleDayForecast> extendedForecast;
    private int rainRecommendationThreshold;

    public MultiDayForecast(ArrayList<SingleDayForecast> extendedForecast, int rainRecommendationThreshold) {
        this.extendedForecast = extendedForecast;
        this.rainRecommendationThreshold = rainRecommendationThreshold;
    }

    public boolean containsSunnyDay() {
        for (int i = 0; i < this.extendedForecast.size(); i++) {
            SingleDayForecast currentForecast = this.extendedForecast.get(i);
            if (currentForecast.getOutlook().equalsIgnoreCase("Sunny")) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public double getAverageHighTemperature() {
        int highTempSum = 0;
        for (int i = 0; i < this.extendedForecast.size(); i++) {
            SingleDayForecast currentForecast = this.extendedForecast.get(i);
            highTempSum += currentForecast.getHighTemperature();
        }

        return highTempSum / this.extendedForecast.size();
    }

    // There are three kinds of cases we can test here. What are they?
    public boolean rainJacketRecommended(int day) {
        SingleDayForecast dayForecast = this.extendedForecast.get(day);
        return dayForecast.getPercentChanceRain() >= this.rainRecommendationThreshold;
    }
}
