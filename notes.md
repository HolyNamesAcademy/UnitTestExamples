# Notes for in-class unit test examples

## Creating tests from existing code

  1. Move your editor cursor (not the mouse) over a class name and hit `alt + Enter` (`Option + Enter` for Mac?)
  2. Choose "Create Test"
  3. For "Testing Library", choose "JUnit4" from the dropdown
     * You will see an error that says "JUnit4 library not found in the module".
     * Click "Fix" and select the option to `Copy 'JUnit' library files to` and leave the default path as-is. This copies the necessary stuff we need in order to run unit tests.
  4. Tests are expressed in a specific way in the code so that JUnit can find them:
     * Must be a `public void` method
     * Must have an `@Test` attribute

## Notes for lecturer

  * `SingleDayForecast` is a simple class that keeps track of the high/low temps for the day, the percent chance of rain (as an `int` between 0 and 100), and the outlook for the day (e.g. "Sunny", "Partly Cloudy", etc.). It does not contain additional logic other than getting/setting the values of each property.
  * `MultiDayForecast` keeps track of the single-day forecasts for an arbitrary number of days in the future (as an `ArrayList`. It also has a threshold for recommending a rain jacket; if the percent chance of rain on a particular day is greater than or equal to the threshold, it should recommend to the user that they wear a rain jacket on that day.
  * Write tests as a class for `MultiDayForecast`. Instead of showing the implementation of the methods, hide them away by folding them in the IDE. Instead, discuss how we will pretend that no implementation exists yet. We should first determine what it should do and how it should behave in response to different kinds of input. 
  * Ask for students to suggest tests for `rainJacketRecommended` first. Below are the tests that would provide good coverage (may want to write only one or two in the interest of time):
    1. Forecasted percentage below threshold
    2. Forecasted percentage above threshold
    3. Forecasted percentage at exactly the threshold
  * Next do `containsSunnyDay`: 
    1. No sunny days in the forecast (will return `false`)
    2. One sunny day at the beginning of the forecast (will return `true`)
    3. One sunny day anywhere but the beginning of the forecast: should return `true` but will return `false` because of a bug in the code. 
         * Can they spot the mistake in the code?
         * Illustrates the importance of testing different kinds of cases. Did you expect one of the "one sunny day" cases to fail after one kind already passed? Probably not!