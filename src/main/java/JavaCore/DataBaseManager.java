package JavaCore;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseManager {
    private String dbConnectionURL;
    private final String CREATE_STATEMENT = "create table forecast " +
            "(id integer primary key autoincrement, date text, day_temp integer, day_feels_like integer, " +
            "day_condition text, night_temp integer, night_feels_like integer, night_condition text)";
    private final String INSERT_STATEMENT = "insert into forecast (date, day_temp, day_feels_like, day_condition," +
            " night_temp, night_feels_like, night_condition) values (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_STATEMENT = "select * from forecast";

    public DataBaseManager(String dbName) {
        this.dbConnectionURL = "jdbc:sqlite:"+dbName+".db";
    }

    public boolean createTable() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.dbConnectionURL);
            Statement statement = connection.createStatement();
            return statement.execute(CREATE_STATEMENT);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        throw new SQLException("Создание таблицы не выполнено");
    }

    public int[] saveForecast(WeatherForecast weatherForecast) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.dbConnectionURL);
            PreparedStatement saveWeather = connection.prepareStatement(INSERT_STATEMENT);
            for(Forecast forecast : weatherForecast.getForecasts()) {
                saveWeather.setString(1, forecast.getDate());
                saveWeather.setInt(2, forecast.getParts().getDay().getTemp());
                saveWeather.setInt(3, forecast.getParts().getDay().getFeelsLike());
                saveWeather.setString(4, forecast.getParts().getDay().getCondition().name());
                saveWeather.setInt(5, forecast.getParts().getNight().getTemp());
                saveWeather.setInt(6, forecast.getParts().getNight().getFeelsLike());
                saveWeather.setString(7, forecast.getParts().getNight().getCondition().name());
                saveWeather.addBatch();
            }
            return saveWeather.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public WeatherForecast loadForecast() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.dbConnectionURL);
            Statement loadWeather = connection.createStatement();
            ResultSet rows = loadWeather.executeQuery(SELECT_STATEMENT);

            ArrayList<Forecast> forecasts = new ArrayList<>();
            while (rows.next()) {
                Part day = new Part();
                day.setTemp(rows.getInt("day_temp"));
                day.setFeelsLike(rows.getInt("day_feels_like"));
                day.setCondition(Condition.valueOf(rows.getString("day_condition")));

                Part night = new Part();
                night.setTemp(rows.getInt("night_temp"));
                night.setFeelsLike(rows.getInt("night_feels_like"));
                night.setCondition(Condition.valueOf(rows.getString("night_condition")));

                Parts parts = new Parts();
                parts.setDay(day);
                parts.setNight(night);

                Forecast forecast = new Forecast();
                forecast.setDate(rows.getString("date"));
                forecast.setParts(parts);

                forecasts.add(forecast);
            }
            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setForecasts(forecasts.toArray(Forecast[]::new));
            return weatherForecast;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }
}
