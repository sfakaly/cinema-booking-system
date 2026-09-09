package io.github.sfakaly;

public class BookingService {
    private CinemaDatabase db;

    public BookingService(CinemaDatabase db) {
        this.db = db;
    }

    public boolean buyTicket(int sessionId, String customerName) {
        Session session = db.findSessionById(sessionId);
        if (session == null) {
            System.out.println("Error: session not found");
            return false;
        }

        if (session.getAvailableSeats() <= 0) {
            System.out.println("Error: no available seats");
            return false;
        }

        session.setAvailableSeats(session.getAvailableSeats() - 1);
        Ticket newTicket = new Ticket(sessionId, customerName);
        db.getTickets().add(newTicket);
        System.out.println("Successfully acquired.");
        return true;
    }
}
