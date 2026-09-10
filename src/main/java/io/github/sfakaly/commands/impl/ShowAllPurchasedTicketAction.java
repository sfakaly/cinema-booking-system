package io.github.sfakaly.commands.impl;

import io.github.sfakaly.CinemaDatabase;
import io.github.sfakaly.models.Ticket;
import io.github.sfakaly.commands.MenuAction;

public class ShowAllPurchasedTicketAction implements MenuAction {
    private CinemaDatabase db;

    public ShowAllPurchasedTicketAction(CinemaDatabase db) {
        this.db = db;
    }

    @Override
    public void execute() {
        for (Ticket ticket: db.getTickets()) {
            System.out.println(ticket);
        }
    }

    @Override
    public String getDescription() {
        return "Show all bought tickets";
    }
}
