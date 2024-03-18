//Shareen Bailey, CSE 340, MP2, Summer session B
import java.util.Scanner;

public class Device {
    private String SKU;
    private String name;
    private boolean available;
    
    /*
     * This is basically the primary device class. This class sets up the menu,
     * provides constructors, and does all the setting and getting. It is the 
     * framework for what allows this program to function.
     */
    
    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        Setup deviceDriver = new Setup();

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. List Devices by Title");
            System.out.println("2. Add New Devices");
            System.out.println("3. Edit Device Information");
            System.out.println("4. Search by Device Name");
            System.out.println("5. Check Out Devices");
            System.out.println("6. Check In Devices");
            System.out.println("7. Exit");

            System.out.print("Select menu options 1-7: ");
            
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    deviceDriver.printList();
                    break;
                case 2:
                    deviceDriver.addDevice();
                    break;
                case 3:
                	deviceDriver.editDevice();
                    break;
                case 4:
                	deviceDriver.searchDevice();
                    break;
                case 5:
                	deviceDriver.checkOutDevice();
                    break;
                case 6:
                	deviceDriver.checkInDevice();
                	break;
                case 7:
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
    
    
    //setup constructors
    public Device() {
    	
    }
    
    public Device(String SKU, String name, boolean available) {
        this.SKU = SKU;
        this.name = name;
        this.available = available;
    }

    //SKU getter
    public String getSKU() {
        return SKU;
    }

    //SKU setter
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    //Name egtter
    public String getName() {
        return name;
    }

    //Name setter
    public void setName(String name) {
        this.name = name;
    }

    //Availability getter
    public String getAvailable() {
        if (available == true) {
        	return "Available";
        } else {
        	return "Checked out";
        }
    }

    //Availability setter
    public void setAvailable(boolean available) {
        this.available = available;
    }
}