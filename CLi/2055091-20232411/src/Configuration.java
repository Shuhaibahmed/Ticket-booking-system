import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private int numberOfVendors;
    private int numberOfCustomers;

    private Scanner scanner;

    // Constructor
    public Configuration() {
        scanner = new Scanner(System.in);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("---Welcome to Ticket System Configuration--");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        maxTicketCapacity = getValidInput("Enter max ticket capacity  : ", true);
        totalTickets = getValidInput("Enter total tickets available : ", true,maxTicketCapacity);
        ticketReleaseRate = getValidInput("Enter ticket release rate in seconds  : ", false);
        customerRetrievalRate = getValidInput("Enter customer retrieval rate in seconds  : ", false);
        numberOfCustomers = getValidInput("Enter number of customers in the system : ", true);
        numberOfVendors = getValidInput("Enter number of vendors in the system : ", true);

        // Save inputs to a text file
        saveInputsToFile();
    }

    // Overloaded getValidInput methods
    private int getValidInput(String prompt, boolean positive) {
        return getValidInput(prompt, positive, Integer.MAX_VALUE);
    }

    private int getValidInput(String prompt, boolean positive, int maxValue) {
        int value = -1;

        while (value <= 0 || value > maxValue) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());

                if (positive && value <= 0) {
                    System.out.println("Error: Value must be greater than 0.");
                } else if (value > maxValue) {
                    System.out.println("Error: Value must be less than or equal to " + maxValue + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
        return value;
    }

    // Method to save inputs to a text file
    private void saveInputsToFile() {
        try (FileWriter writer = new FileWriter("ticket_system_configuration.txt")) {
            writer.write("---Ticket System Configuration---\n");
            writer.write("Total Tickets Available: " + totalTickets + "\n");
            writer.write("Max Ticket Capacity: " + maxTicketCapacity + "\n");
            writer.write("Ticket Release Rate (seconds): " + ticketReleaseRate + "\n");
            writer.write("Customer Retrieval Rate (seconds): " + customerRetrievalRate + "\n");
            writer.write("Number of Customers: " + numberOfCustomers + "\n");
            writer.write("Number of Vendors: " + numberOfVendors + "\n");
            System.out.println("Configuration saved to 'ticket_system_configuration.txt'");
        } catch (IOException e) {
            System.out.println("Error: Could not save configuration to file.");
            e.printStackTrace();
        }
    }

    // Getters for the class properties
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getNumberOfVendors() {
        return numberOfVendors;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
}
