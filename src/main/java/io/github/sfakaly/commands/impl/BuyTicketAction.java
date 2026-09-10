package io.github.sfakaly.commands.impl;

import io.github.sfakaly.BookingService;
import io.github.sfakaly.commands.MenuAction;
import io.github.sfakaly.commands.UserInteraction;

import java.util.Scanner;

public class BuyTicketAction implements MenuAction {
    private BookingService bookingService;
    private UserInteraction ui;

    public BuyTicketAction(BookingService bookingService, UserInteraction ui) {
        this.bookingService = bookingService;
        this.ui = ui;
    }

    @Override
    public void execute() {
        int sessionId = ui.readInt("Enter the session id");
        String customerName = ui.readString("Enter your name");

        boolean success = bookingService.buyTicket(sessionId, customerName);
        if (success) {
            ui.printSuccessMessage("You Successfully buy a ticket!");
        } else {
            ui.printError("Oh no! You can't buy a ticket.");
        }
    }

    @Override
    public String getDescription() {
        return "buy a ticket";
    }

    @Override
    public int getCode() {
        return 2;
    }
}
