import java.util.LinkedList;
import java.util.Queue;

class TicketPool {
    private final int maxCapacity;
    private final Queue<Ticket> ticketQueue = new LinkedList<>();
    private int ticketCounter = 0;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTicket(Ticket ticket) {
        while (isQueueFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        ticketQueue.add(ticket);
        ticketCounter++;
        System.out.println(Thread.currentThread().getName() + " added: " + ticket);
        notifyAll();
    }

    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        Ticket ticket = ticketQueue.poll();
        System.out.println(Thread.currentThread().getName() + " purchased: " + ticket);
        notifyAll();
        return ticket;
    }

    public synchronized boolean isQueueFull() {
        return ticketQueue.size() >= maxCapacity;
    }

    public synchronized void displaySummary() {
        System.out.println("Tickets currently in pool: " + ticketQueue.size());
        System.out.println("Tickets sold so far: " + ticketCounter);
    }
}
