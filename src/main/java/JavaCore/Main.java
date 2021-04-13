package JavaCore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    ForecastFetcher ff = new ForecastFetcher();

	    try {
	        WeatherForecast result = ff.fetchForecast();
	        System.out.println(result);
        } catch (IOException e) {
	        System.out.println(e.getMessage());
        }
    }
}
