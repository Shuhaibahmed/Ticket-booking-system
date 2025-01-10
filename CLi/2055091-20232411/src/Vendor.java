import java.math.BigDecimal;

class Vendor implements Runnable {
    private int totalTickets;
    private int ticketReleaseRate;
    private TicketPool ticketPool;

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {
            if (ticketPool.isQueueFull()) {
                break; // Stop adding tickets if the queue is full
            }
            Ticket ticket = new Ticket(i,"" ,new BigDecimal("1000"));
            ticketPool.addTicket(ticket);
            try {
                Thread.sleep(ticketReleaseRate * 1000); // Delay for ticket release
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
                break;
            }
        }
    }
}
