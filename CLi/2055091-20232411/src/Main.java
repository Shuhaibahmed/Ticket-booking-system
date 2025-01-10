import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        ThreadManager threadManager = new ThreadManager(
                config.getNumberOfVendors(),
                config.getTotalTickets(),
                config.getTicketReleaseRate(),
                config.getCustomerRetrievalRate(),
                config.getNumberOfCustomers(),
                ticketPool
        );

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("\nConfiguration complete. Starting the ticket system...\n");

        while (!exit) {
            System.out.println("Choose an option (Enter the Number):");
            System.out.println("1. Start Ticketing Operations");
            System.out.println("2. Stop Ticketing Operations");
            System.out.println("3. View Ticket Summary");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    threadManager.startThreads();
                    System.out.println("Ticketing operations started with " +
                            config.getNumberOfVendors() + " vendors and " +
                            config.getNumberOfCustomers() + " customers.");
                    break;
                case 2:
                    threadManager.stopThreads();
                    System.out.println("Ticketing operations stopped.");
                    break;
                case 3:
                    ticketPool.displaySummary();
                    break;
                case 4:
                    threadManager.stopThreads();
                    exit = true;
                    System.out.println("Exiting the ticket system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
