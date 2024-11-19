public abstract class EnergySource {
    protected double energyProduced;
    protected double maxEnergy; // Energy produced in kWh

    public EnergySource(double maxEnergy) {
        this.maxEnergy = maxEnergy;  // Initialize maxEnergy for the energy source
    }


    // Method to simulate energy production (to be overridden by subclasses)
    public abstract void produceEnergy();

    public double getEnergyProduced() {
        return energyProduced;
    }

    public void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }
}

class SolarEnergy extends EnergySource {

    public SolarEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public void produceEnergy() {
        // Simulating solar energy production (random value between 0 and 10 kWh)
        energyProduced = Math.random() * 10;
        System.out.println("Solar Energy produced: " + energyProduced + " kWh");

        // Log the energy production
        LogManager.log("Solar Energy produced: " + energyProduced + " kWh");

    }
}

class WindEnergy extends EnergySource {
    @Override
    public void produceEnergy() {
        // Simulating wind energy production (random value between 0 and 5 kWh)
        energyProduced = Math.random() * 5;
        System.out.println("Wind Energy produced: " + energyProduced + " kWh");

        LogManager.log("Wind Energy produced: " + energyProduced + " kWh");
    }
}

class GridEnergy extends EnergySource {
    @Override
    public void produceEnergy() {
        // Simulating grid energy production (fixed value of 20 kWh)
        energyProduced = 20;
        System.out.println("Grid Energy produced: " + energyProduced + " kWh");

        LogManager.log("Grid Energy produced: " + energyProduced + " kWh");
    }
}
