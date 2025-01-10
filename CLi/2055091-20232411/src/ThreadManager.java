import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    private final List<Thread> threads = new ArrayList<>();
    private final TicketPool ticketPool;

    public ThreadManager(int vendorCount, int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int customerCount, TicketPool ticketPool) {
        this.ticketPool = ticketPool;

        // Initialize vendors
        for (int i = 0; i < vendorCount; i++) {
            Vendor vendor = new Vendor(totalTickets / vendorCount, ticketReleaseRate, ticketPool);
            Thread vendorThread = new Thread(vendor, "Vendor-" + (i + 1));
            threads.add(vendorThread);
        }

        // Initialize customers
        for (int i = 0; i < customerCount; i++) {
            Customer customer = new Customer(ticketPool, customerRetrievalRate, totalTickets / customerCount);
            Thread customerThread = new Thread(customer, "Customer-" + (i + 1));
            threads.add(customerThread);
        }
    }

    public void startThreads() {
        threads.forEach(Thread::start);
    }

    public void stopThreads() {
        threads.forEach(Thread::interrupt);
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
