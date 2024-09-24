package Question1.Obeserver;

public class WeatherDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("WeatherDisplay: Temperature: " + temperature + ", Humidity: " + humidity);
    }
}
