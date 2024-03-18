//Shareen Bailey, CSE 340, MP2, Summer session B
/*
 * This is essentially the main menu. All this class does is call
 * the method from Setup that prints the menu to the console.
 */
public class MP2Driver {
    public static void main(String[] args) {
        Device newSetup = new Device();
        newSetup.displayMenu();
    }
}