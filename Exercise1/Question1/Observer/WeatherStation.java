package Question1.Obeserver;
import Question1.Obeserver.logs.Logger;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void registerObserver(Observer observer) {
        if (observer == null) {
            Logger.log("Observer cannot be null during registration.");
            return;
        }
        observers.add(observer);
        Logger.log("Observer registered.");
    }

    public void removeObserver(Observer observer) {
        if (observer == null) {
            Logger.log("Observer cannot be null during removal.");
            return;
        }
        observers.remove(observer);
        Logger.log("Observer removed.");
    }

    public void setWeatherData(float temperature, float humidity) {
        if (isValidTemperature(temperature) && isValidHumidity(humidity)) {
            this.temperature = temperature;
            this.humidity = humidity;
            notifyObservers();
            Logger.log("Weather data updated: Temperature " + temperature + ", Humidity " + humidity);
        } else {
            Logger.log("Invalid weather data: Temperature " + temperature + ", Humidity " + humidity);
        }
    }

    private boolean isValidTemperature(float temperature) {
        return temperature >= -100 && temperature <= 100;
    }

    private boolean isValidHumidity(float humidity) {
        return humidity >= 0 && humidity <= 100;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}
