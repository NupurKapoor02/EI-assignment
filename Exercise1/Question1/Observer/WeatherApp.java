package Question1.Obeserver;
import java.util.Scanner;
import Question1.Obeserver.logs.Logger;
public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay weatherDisplay = new WeatherDisplay();
        MobileApp mobileApp = new MobileApp();

        weatherStation.registerObserver(weatherDisplay);
        weatherStation.registerObserver(mobileApp);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter temperature (-100 to 100, or type 'exit' to quit): ");
            String temperatureInput = scanner.nextLine();
            if (temperatureInput.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            System.out.print("Enter humidity (0 to 100): ");
            String humidityInput = scanner.nextLine();
            try {
                float temperature = Float.parseFloat(temperatureInput);
                float humidity = Float.parseFloat(humidityInput);
                weatherStation.setWeatherData(temperature, humidity);
            } catch (NumberFormatException e) {
                Logger.log("Invalid input format. Please enter numeric values.");
            }
        }

        scanner.close();
        Logger.log("Weather App has exited.");
    }
}
