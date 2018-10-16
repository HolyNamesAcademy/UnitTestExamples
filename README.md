# Unit Testing Examples

## Creating tests from existing code

  1. Move your editor cursor (not the mouse) over a class name and hit `alt + Enter` (`Option + Enter` for Mac?)
  2. Choose "Create Test"
  3. For "Testing Library", choose "JUnit4" from the dropdown
     * You will see an error that says "JUnit4 library not found in the module".
     * Click "Fix" and select the option to `Copy 'JUnit' library files to` and leave the default path as-is. This copies the necessary stuff we need in order to run unit tests.
  4. Tests are expressed in a specific way in the code so that JUnit can find them:
     * Must be a `public void` method
     * Must have an `@Test` attribute

## Classes

  * `SingleDayForecast` is a simple class that keeps track of the high/low temps for the day, the percent chance of rain (as an `int` between 0 and 100), and the outlook for the day (e.g. "Sunny", "Partly Cloudy", etc.). It does not contain additional logic other than getting/setting the values of each property.
  * `MultiDayForecast` keeps track of the single-day forecasts for an arbitrary number of days in the future (as an `ArrayList`. It also has a threshold for recommending a rain jacket; if the percent chance of rain on a particular day is greater than or equal to the threshold, it should recommend to the user that they wear a rain jacket on that day.