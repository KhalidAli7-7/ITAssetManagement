import java.io.*;
import java.util.*;

public class TicketManager {
    private ArrayList<Ticket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }

    // Add a new support ticket
    public void createTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket created for Asset: " + ticket.getAssetId());
    }

    // Update the status of a ticket by its ID
    public void updateTicketStatus(String ticketId, String newStatus) {
        for (Ticket t : tickets) {
            if (t.getTicketId().equals(ticketId)) {
                t.setStatus(newStatus);
                System.out.println("Ticket #" + ticketId + " updated to: " + newStatus);
                return;
            }
        }
        System.out.println("Ticket #" + ticketId + " not found.");
    }

    // Print all tickets
    public void printAllTickets() {
        System.out.println("\n--- All Support Tickets ---");
        for (Ticket t : tickets) {
            System.out.println(t.getSummary());
        }
    }

    // Print only open/unresolved tickets
    public void printOpenTickets() {
        System.out.println("\n--- Open Support Tickets ---");
        for (Ticket t : tickets) {
            if (!t.getStatus().equals("RESOLVED")) {
                System.out.println(t.getSummary());
            }
        }
    }
    // Save all tickets to tickets.txt
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Ticket t : tickets) {
                // Format: ticketId,assetId,description,status
                writer.println(t.getTicketId() + "," + t.getAssetId() + "," + t.getDescription() + "," + t.getStatus());
            }
            System.out.println("Tickets saved successfully to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error saving tickets: " + e.getMessage());
        }
    }

    // Load tickets from tickets.txt
    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            tickets.clear();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String ticketId = parts[0];
                    String assetId = parts[1];
                    String description = parts[2];
                    String status = parts[3];

                    Ticket ticket = new Ticket(ticketId, assetId, description);
                    ticket.setStatus(status);
                    tickets.add(ticket);
                }
            }
            System.out.println("Tickets loaded successfully from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tickets: " + e.getMessage());
        }
    }
}