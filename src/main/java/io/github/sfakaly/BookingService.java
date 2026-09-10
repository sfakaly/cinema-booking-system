package io.github.sfakaly;

import io.github.sfakaly.commands.UserInteraction;
import io.github.sfakaly.models.Session;
import io.github.sfakaly.models.Ticket;

public class BookingService {
    private CinemaDatabase db;
    private final UserInteraction ui;

    public BookingService(CinemaDatabase db, UserInteraction ui) {
        this.db = db;
        this.ui = ui;
    }

    public boolean buyTicket(int sessionId, String customerName) {
        Session session = db.findSessionById(sessionId);
        if (session == null) {
            ui.printError("Error: session not found");
            return false;
        }

        if (session.getAvailableSeats() <= 0) {
            ui.printError("Error: no available seats");
            return false;
        }

        session.setAvailableSeats(session.getAvailableSeats() - 1);
        Ticket newTicket = new Ticket(sessionId, customerName);
        db.getTickets().add(newTicket);
        ui.printSuccessMessage("Successfully acquired.");
        return true;
    }
}
