public class SmartDevice {
    private String name;
    private double powerConsumption;  // Energy consumed when the device is on (in kWh)
    private boolean isOn; // Track if device is on or off

    // Constructor
    public SmartDevice(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.isOn = false;
    }

    // Toggle the device on or off
    public void toggle() {
        this.isOn = !this.isOn;
    }

    // Consume energy (if the device is on)
    public void consumeEnergy() {
        if (isOn) {
            System.out.println(name + " is consuming " + powerConsumption + " kWh.");
        }
    }

    public String getName() {
        return name;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public boolean isOn() {
        return isOn;
    }
}
