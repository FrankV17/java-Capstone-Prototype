import java.util.*;

public class SmartHouse {

    public static void main(String[] args) {
        try {
            // Step 1: Load initial settings
            SettingsManager.loadSettings(); // Load configuration from settings.properties

            // Step 2: Initialize energy sources based on the loaded settings
            EnergySource solar = new SolarEnergy(10); // Solar max energy set to 10 kWh (as per settings)
            EnergySource wind = new WindEnergy(5);   // Wind max energy set to 5 kWh
            EnergySource grid = new GridEnergy(20);  // Grid max energy set to 20 kWh

            // Step 3: Initialize smart devices based on the loaded settings
            List<SmartDevice> devices = new ArrayList<>();
            devices.add(new SmartDevice("Smart Light", 0.5));  // Light consumption 0.5 kWh
            devices.add(new SmartDevice("Smart AC", 2.0));     // AC consumption 2.0 kWh
            devices.add(new SmartDevice("Smart Fridge", 1.5)); // Fridge consumption 1.5 kWh

            // Step 4: Initialize Energy Manager with energy sources and devices
            List<EnergySource> energySources = new ArrayList<>(Arrays.asList(solar, wind, grid));
            EnergyManager manager = new EnergyManager(energySources, devices);

            // Step 5: Run the user interface
            UserInterface ui = new UserInterface(manager);
            ui.showMenu();

        } catch (Exception e) {
            // Handle any other unforeseen errors
            LogManager.log("Error occurred: " + e.getMessage());
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
