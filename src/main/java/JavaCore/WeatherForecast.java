package JavaCore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
    @JsonProperty(value = "geo_object")
    private GeoObject geoObject;
    private Forecast[] forecasts;

    public GeoObject getGeoObject() {
        return geoObject;
    }

    public void setGeoObject(GeoObject geoObject) {
        this.geoObject = geoObject;
    }

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public void setForecasts(Forecast[] forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.geoObject != null) {
            result += "Погода в " + this.geoObject.toString() + "\n";
        }
        for (Forecast forecast : this.forecasts) {
            result += forecast.toString() + "\n";
        }
        return result;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class GeoObject {
    private Country country;
    private Province province;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return province.getName() + " (" + country.getName() + ")";
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Country {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Province {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Forecast {
    private String date;
    private Parts parts;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        String result = date + "\n";
        result += "\t Днём " + parts.getDay().toString();
        result += "\n\t Ночью " + parts.getNight().toString();
        return result;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Parts {
    @JsonProperty(value = "day_short")
    private Part day;
    @JsonProperty(value = "night_short")
    private Part night;

    public Part getDay() {
        return day;
    }

    public void setDay(Part day) {
        this.day = day;
    }

    public Part getNight() {
        return night;
    }

    public void setNight(Part night) {
        this.night = night;
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Part {
    private int temp;
    @JsonProperty(value = "feels_like")
    private int feelsLike;
    private Condition condition;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "температура " + this.temp + ", ощущается как " + this.feelsLike + ", " + this.condition;
    }
}

enum Condition {
    CLEAR,
    @JsonProperty(value = "partly-cloudy")
    PARTLY_CLOUDY,
    CLOUDY,
    OVERCAST,
    @JsonProperty(value = "partly-cloudy-and-light-rain")
    PARTLY_CLOUDY_AND_LIGHT_RAIN,
    @JsonProperty(value = "partly-cloudy-and-rain")
    PARTLY_CLOUDY_AND_RAIN,
    @JsonProperty(value = "overcast-and-rain")
    OVERCAST_AND_RAIN,
    @JsonProperty(value = "overcast-thunderstorms-with-rain")
    OVERCAST_THUNDERSTORMS_WITH_RAIN,
    @JsonProperty(value = "cloudy-and-light-rain")
    CLOUDY_AND_LIGHT_RAIN,
    @JsonProperty(value = "overcast-and-light-rain")
    OVERCAST_AND_LIGHT_RAIN,
    @JsonProperty(value = "cloudy-and-rain")
    CLOUDY_AND_RAIN,
    @JsonProperty(value = "overcast-and-wet-snow")
    OVERCAST_AND_WET_SNOW,
    @JsonProperty(value = "partly-cloudy-and-light-snow")
    PARTLY_CLOUDY_AND_LIGHT_SNOW,
    @JsonProperty(value = "partly-cloudy-and-snow")
    PARTLY_CLOUDY_AND_SNOW,
    @JsonProperty(value = "overcast-and-snow")
    OVERCAST_AND_SNOW,
    @JsonProperty(value = "cloudy-and-light-snow")
    CLOUDY_AND_LIGHT_SNOW,
    @JsonProperty(value = "overcast-and-light-snow")
    OVERCAST_AND_LIGHT_SNOW,
    @JsonProperty(value = "cloudy-and-snow")
    CLOUDY_AND_SNOW;


    @Override
    public String toString() {
        String result = "";
        switch (this) {
            case CLEAR:
                result = "ясно";
                break;
            case PARTLY_CLOUDY:
                result = "малооблачно";
                break;
            case CLOUDY:
                result = "облачно с прояснениями";
                break;
            case OVERCAST:
                result = "пасмурно";
                break;
            case PARTLY_CLOUDY_AND_LIGHT_RAIN:
                result = "малооблачно, небольшой дождь";
                break;
            case PARTLY_CLOUDY_AND_RAIN:
                result = "малооблачно, дождь";
                break;
            case OVERCAST_AND_RAIN:
                result = "значительная облачность, сильный дождь";
                break;
            case OVERCAST_THUNDERSTORMS_WITH_RAIN:
                result = "сильный дождь с грозой";
                break;
            case CLOUDY_AND_LIGHT_RAIN:
                result = "облачно, небольшой дождь";
                break;
            case OVERCAST_AND_LIGHT_RAIN:
                result = "значительная облачность, небольшой дождь";
                break;
            case CLOUDY_AND_RAIN:
                result = "облачно, дождь";
                break;
            case OVERCAST_AND_WET_SNOW:
                result = "дождь со снегом";
                break;
            case PARTLY_CLOUDY_AND_LIGHT_SNOW:
                result = "небольшой снег";
                break;
            case PARTLY_CLOUDY_AND_SNOW:
                result = "малооблачно, снег";
                break;
            case OVERCAST_AND_SNOW:
                result = "снегопад";
                break;
            case CLOUDY_AND_LIGHT_SNOW:
                result = "облачно, небольшой снег";
                break;
            case OVERCAST_AND_LIGHT_SNOW:
                result = "значительная облачность, небольшой снег";
                break;
            case CLOUDY_AND_SNOW:
                result = "облачно, снег";
                break;
        }
        return result;
    }
}