import java.util.Scanner;

public class App {
    private AssetManager assetManager;
    private TicketManager ticketManager;
    private Scanner scanner;

    public App() {
        assetManager = new AssetManager();
        ticketManager = new TicketManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Load existing assets from file on launch
        assetManager.loadFromFile("assets.txt");
        ticketManager.loadFromFile("tickets.txt");

        boolean running = true;
        while (running) {
            System.out.println("\n=== IT ASSET & SUPPORT SYSTEM ===");
            System.out.println("1. Add New Asset");
            System.out.println("2. View All Assets");
            System.out.println("3. View Available Assets");
            System.out.println("4. Create Support Ticket");
            System.out.println("5. View All Tickets");
            System.out.println("6. View Open Tickets");
            System.out.println("7. Update Ticket Status");
            System.out.println("8. Save & Exit");
            System.out.print("Select an option (1-8): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Asset ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Asset Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    assetManager.addAsset(new Asset(id, name, category));
                    break;
                case "2":
                    assetManager.printAllAssets();
                    break;
                case "3":
                    assetManager.printAvailableAssets();
                    break;
                case "4":
                    System.out.print("Enter Ticket ID: ");
                    String tId = scanner.nextLine();
                    System.out.print("Enter Asset ID: ");
                    String aId = scanner.nextLine();
                    System.out.print("Enter Issue Description: ");
                    String desc = scanner.nextLine();
                    ticketManager.createTicket(new Ticket(tId, aId, desc));
                    break;
                case "5":
                    ticketManager.printAllTickets();
                    break;
                case "6":
                    ticketManager.printOpenTickets();
                    break;
                case "7":
                    System.out.print("Enter Ticket ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Status (OPEN, IN_PROGRESS, RESOLVED): ");
                    String status = scanner.nextLine();
                    ticketManager.updateTicketStatus(updateId, status);
                    break;
                case "8":
                    assetManager.saveToFile("assets.txt");
                    ticketManager.saveToFile("tickets.txt");
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 8.");
            }
        }
    }
}