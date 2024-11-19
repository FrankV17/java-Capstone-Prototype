import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsManager {

    public static void loadSettings() {
        // Create a Properties object to hold the settings
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("settings.properties")) {
            // Load the properties file
            properties.load(input);

            // Loading energy source configuration from the properties file
            double solarMax = Double.parseDouble(properties.getProperty("solarEnergyMax"));
            double windMax = Double.parseDouble(properties.getProperty("windEnergyMax"));
            double gridMax = Double.parseDouble(properties.getProperty("gridEnergyMax"));

            // Loading device power consumption from the properties file
            double lightConsumption = Double.parseDouble(properties.getProperty("smartLightConsumption"));
            double acConsumption = Double.parseDouble(properties.getProperty("smartACConsumption"));
            double fridgeConsumption = Double.parseDouble(properties.getProperty("smartFridgeConsumption"));

            // Output the loaded settings (optional, for debugging)
            System.out.println("Settings loaded:");
            System.out.println("Solar max energy: " + solarMax + " kWh");
            System.out.println("Wind max energy: " + windMax + " kWh");
            System.out.println("Grid max energy: " + gridMax + " kWh");
            System.out.println("Smart Light consumption: " + lightConsumption + " kWh");
            System.out.println("Smart AC consumption: " + acConsumption + " kWh");
            System.out.println("Smart Fridge consumption: " + fridgeConsumption + " kWh");

            // Pass these values to the relevant classes (we will do this in the next steps)

        } catch (IOException e) {
            System.out.println("Error reading settings: " + e.getMessage());
        }
    }
}
