import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketingSystem {
    private Queue<Ticket> ticketQueue;
    private int totalTickets;
    private int ticketsLeft;
    private boolean systemRunning;
    private boolean ticketingOperationsRunning;
    private int maxTicketCapacity;
    private Scanner scanner;

    public TicketingSystem(int totalTickets, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketsLeft = totalTickets;
        this.ticketQueue = new LinkedList<>();
        this.systemRunning = true;
        this.ticketingOperationsRunning = false;
        this.scanner = new Scanner(System.in);

        // Initialize ticket queue with tickets having prices
        for (int i = 1; i <= totalTickets; i++) {
            BigDecimal price = new BigDecimal(1000);  // Set a static price for now
            Ticket ticket = new Ticket(i, "Event4u", price);
            ticketQueue.offer(ticket);
        }
    }

    // Simulate buying tickets
    public void buyTicket(int customerId) {
        if (!ticketQueue.isEmpty()) {
            Ticket ticket = ticketQueue.poll();
            System.out.println("Customer-" + customerId + " purchased: " + ticket);
            ticketsLeft--;
        } else {
            System.out.println("Customer-" + customerId + " waiting for tickets.");
        }
    }

    // Stop ticketing operations once all tickets are sold
    public void stopTicketingOperations() {
        ticketingOperationsRunning = false;
        System.out.println("Ticketing operations stopped.");
    }

    // Display the menu options after the last ticket is purchased
    public void showOptions() {
        if (ticketsLeft == 0) {
            System.out.println("\nAll tickets have been purchased.");
            System.out.println("Choose an option (Enter the Number):");
            System.out.println("1. View Ticket Summary");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewTicketSummary();
                    break;
                case 2:
                    systemRunning = false;
                    ticketingOperationsRunning = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
                    systemRunning = false;
                    ticketingOperationsRunning = false;
                    break;
            }
        } else {
            // After every purchase, check if tickets are left and show options accordingly
            if (ticketsLeft == 0) {
                showOptions(); // Call to show options if tickets are finished
            }
        }
    }

    // Display ticket summary (total tickets, remaining tickets, etc.)
    public void viewTicketSummary() {

    }

    // Start ticketing operations
    public void startTicketingOperations(int numberOfCustomers) {
        ticketingOperationsRunning = true;
        int customerId = 1;
        while (ticketingOperationsRunning && ticketsLeft > 0) {
            if (customerId > numberOfCustomers) {
                customerId = 1; // Restart customer count if needed
            }

            // Simulate customer buying a ticket
            buyTicket(customerId);
            customerId++;

            // Show options after last ticket is purchased
            showOptions();
        }
    }

    // Run the ticketing system menu
    public void run() {
        while (systemRunning) {

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ticketing operations started with " + 10 + " vendors and " + 10 + " customers.");
                    startTicketingOperations(10); // Start ticketing operations with 10 customers
                    break;
                case 2:
                    stopTicketingOperations();
                    break;
                case 3:
                    viewTicketSummary();
                    break;
                case 4:
                    systemRunning = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Configuration data: Assuming 3 tickets and a max capacity of 10 for this example
        int totalTickets = 3;
        int maxTicketCapacity = 10;

        // Create TicketingSystem object and run the system
        TicketingSystem system = new TicketingSystem(totalTickets, maxTicketCapacity);
        system.run();
    }
}
