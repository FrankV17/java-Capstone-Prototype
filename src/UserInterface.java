import java.util.Scanner;

public class UserInterface {
    private EnergyManager manager;
    private Scanner scanner;

    public UserInterface(EnergyManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Smart House Energy Management ===");
            System.out.println("1. Produce Energy");
            System.out.println("2. Toggle Device");
            System.out.println("3. Display Energy Stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.produceEnergy(); // This will produce and print energy
                    break;
                case 2:
                    System.out.print("Enter device name to toggle: ");
                    String deviceName = scanner.next();
                    manager.toggleDevice(deviceName);
                    break;
                case 3:
                    manager.consumeEnergy();
                    manager.displayEnergyStats(); // This will print energy stats
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
