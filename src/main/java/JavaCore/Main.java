package JavaCore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
    	DataBaseManager dbm = new DataBaseManager("weatherForecast");
    	try {
    		System.out.println(dbm.createTable());
		} catch (SQLException e) {
    		System.out.println(e.getMessage());
		}

	    ForecastFetcher ff = new ForecastFetcher();
	    try {
	        WeatherForecast result = ff.fetchForecast();
	        dbm.saveForecast(result);
	        System.out.println(dbm.loadForecast());
        } catch (IOException e) {
	        System.out.println(e.getMessage());
        } catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

}
