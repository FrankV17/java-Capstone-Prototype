import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EnergyManager {
    private double totalEnergyConsumption;  // Track total energy consumption
    private double totalEnergyProduced;     // Track total energy produced
    private List<EnergySource> energySources; // Energy sources like solar, wind, grid
    private List<SmartDevice> devices;     // Smart devices like lights, AC

    // Constructor to initialize the EnergyManager
    public EnergyManager(List<EnergySource> energySources, List<SmartDevice> devices) {
        this.energySources = energySources;
        this.devices = devices;
        this.totalEnergyConsumption = 0;
        this.totalEnergyProduced = 0;
    }

    // Produce energy from all energy sources and accumulate total energy produced
    public void produceEnergy() {
        // Reset energy produced each time we call this method
        totalEnergyProduced = 0;

        // Generate energy from each source and add it to totalEnergyProduced
        for (EnergySource source : energySources) {
            source.produceEnergy(); // This will print energy produced for each source
            totalEnergyProduced += source.getEnergyProduced();
        }

        // After producing energy, print the total energy produced
        System.out.println("Total Energy Produced from all sources: " + totalEnergyProduced + " kWh");
    }

    // Calculate energy consumed by all devices that are turned on
    public void consumeEnergy() {
        totalEnergyConsumption = 0;  // Reset total consumption
        for (SmartDevice device : devices) {
            device.consumeEnergy();
            if (device.isOn()) {
                totalEnergyConsumption += device.getPowerConsumption();
                LogManager.log(device.getName() + " is consuming " + device.getPowerConsumption() + " kWh.");
            }
        }
    }

    // Display the energy stats to the user (production vs consumption)
    public void displayEnergyStats() {
        System.out.println("Total Energy Produced: " + totalEnergyProduced + " kWh");
        System.out.println("Total Energy Consumed: " + totalEnergyConsumption + " kWh");
        
        // Check if there is enough energy
        if (totalEnergyProduced >= totalEnergyConsumption) {
            System.out.println("Sufficient energy supply.");
        } else {
            System.out.println("Energy shortage! Switching to grid power.");
        }
    }

    // Toggle the device (on or off)
    public void toggleDevice(String deviceName) {
        for (SmartDevice device : devices) {
            if (device.getName().equalsIgnoreCase(deviceName)) {
                device.toggle();
                String status = device.isOn() ? "ON" : "OFF";
                System.out.println(deviceName + " is now " + status);
                LogManager.log(deviceName + " turned " + status);
                return;
            }
        }
        System.out.println("Device not found.");
    }

    public static void loadSettings() {
    Properties properties = new Properties();
    try (FileInputStream input = new FileInputStream("settings.properties")) {
        properties.load(input);
        // Loading settings...
    } catch (IOException e) {
        LogManager.log("Error reading settings: " + e.getMessage());
        System.out.println("Error reading settings: " + e.getMessage());
    }
}

}
