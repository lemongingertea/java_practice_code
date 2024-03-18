//Shareen Bailey, CSE 340, MP2, Summer session B
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is essentially the back end for most of the program work. This class
 * includes all the methods required to perform the various menu options.
 */

public class Setup {
	
    private ArrayList <Device> deviceList;

    //Setup constructor, starts with a few sample devices
    public Setup() {
        deviceList = new ArrayList<>(10);
        
        deviceList.add(new Device("6757A", "Apple 9.7-inch iPad Pro", true));
        deviceList.add(new Device("93P51B", "Amazon Kindle Fire Kids Edition", true));
        deviceList.add(new Device("10N8C", "LeapFrog Epic Learning Tablet", true));
        deviceList.add(new Device("85U2O", "Amazon Kindle Fire HD 8", false));
        deviceList.add(new Device("91H2D", "HP Envy 8 Note", true));
    }

    //prints list of all devices in library
    public void printList() {
    	System.out.println();
    	System.out.println();
    	System.out.println();
        System.out.println("\t\tLibrary Device Checkout System - List");
        System.out.println();
        System.out.println("# SKU \t\t  Name: ");
        
        for (int i = 0; i < deviceList.size(); i++) {
            Device device = deviceList.get(i);
            System.out.printf("%d %-15s %-35s %-15s\n", i+1, device.getSKU(), device.getName(), device.getAvailable());
        }
        System.out.println();
    }

    //add a device to the library
    public void addDevice() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
    	System.out.println();
    	System.out.println();
        System.out.println("\t\tLibrary Device Checkout System - Add New Device");

        System.out.print("SKU: ");
        String SKU = scan.nextLine();
        System.out.println();

        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.println();

        Device newDevice = new Device(SKU.toUpperCase(), name, true);
        deviceList.add(newDevice);
        System.out.printf("Added %s to Catalog.\n\n", name);
    }

    //edit details of a previously added device
    public void editDevice() {
        Scanner scan = new Scanner(System.in);
        
        printList();

        System.out.println();
    	System.out.println();
    	System.out.println();
        System.out.print("Enter Device number to edit: ");
        
        int deviceNum = Integer.parseInt(scan.nextLine());
        System.out.println();

        if (deviceNum < 1 || deviceNum > deviceList.size()) {
            System.out.println("Invalid number.\n");
            return;
        }

        Device device = deviceList.get(deviceNum - 1);

        System.out.print("SKU: ");
        String newSKU = scan.nextLine();
        System.out.println();

        System.out.print("Name: ");
        String newName = scan.nextLine();
        System.out.println();

        device.setSKU(newSKU.toUpperCase());
        device.setName(newName);

        System.out.println("Device information updated.\n");
    }

    //search a device by name or substring of name
    public void searchDevice() {
    	Scanner scan = new Scanner(System.in);

    	System.out.println();
    	System.out.println();
    	System.out.println();
        System.out.print("Enter Device to search for: ");
        String inputString = scan.nextLine();
        System.out.println();
        
        ArrayList<Device> matchingString = new ArrayList<>();
        
        for (int i = 0; i < deviceList.size(); i++) {
            Device device = deviceList.get(i);
            if (device.getName().toLowerCase().contains(inputString.toLowerCase())) {matchingString.add(device);
            }
        }

        if (matchingString.isEmpty()) {
            System.out.println("No devices found.\n");
        } else {
            System.out.printf("Listings for '%s':", inputString);
            System.out.println();
            System.out.println("# SKU \t\t  Name: ");
            for (int i = 0; i < matchingString.size(); i++) {
                Device device = matchingString.get(i);
                System.out.printf("%d %-15s %-35s\n", i+1, device.getSKU(), device.getName());
            }
            System.out.println();
        }
    }

    //change a device availability to not available
    public void checkOutDevice() {
    	Scanner scan = new Scanner(System.in);

    	System.out.println();
    	System.out.println();
    	System.out.println();
        System.out.println("Available Devices:");
        
        ArrayList<Device> availableDevices = new ArrayList<>();
        
        System.out.println("# SKU \t\t  Name: ");
        for (int i = 0; i < deviceList.size(); i++) {
            Device device = deviceList.get(i);
            if (device.getAvailable()== "Available") {
                availableDevices.add(device);
                System.out.printf("%d %-15s %-35s\n", i+1, device.getSKU(), device.getName());
            }
        }

        if (availableDevices.isEmpty()) {
            System.out.println("No available devices to check-out. Try back next week!\n");
            return;
        }

        System.out.println("Enter device number: ");
        int deviceNum = Integer.parseInt(scan.nextLine());

        if (deviceNum < 1 || deviceNum > availableDevices.size()) {
            System.out.println("Invalid number.\n");
            return;
        }

        Device device = availableDevices.get(deviceNum - 1);
        device.setAvailable(false);
        System.out.println("Device checked out.\n");
    }
    
    //check a device back in a return is availability to available
    public void checkInDevice() {
        Scanner scan = new Scanner(System.in);
        
        printList();

        System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.print("Enter device number: ");
    	System.out.println();
        int deviceNum = Integer.parseInt(scan.nextLine());

        if (deviceNum < 1 || deviceNum > deviceList.size()) {
            System.out.println("Invalid number.\n");
            return;
        }

        Device device = deviceList.get(deviceNum - 1);
        if (device.getAvailable() == "Available") {
            System.out.println("Device is already checked in.\n");
        } else {
            device.setAvailable(true);
            System.out.println("Device checked in.\n");
        }
    }
}