package io.github.sfakaly.commands.impl;

import io.github.sfakaly.BookingService;
import io.github.sfakaly.commands.MenuAction;

import java.util.Scanner;

public class BuyTicketAction implements MenuAction {
    private BookingService bookingService;
    private Scanner scanner;

    public BuyTicketAction(BookingService bookingService, Scanner scanner) {
        this.bookingService = bookingService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        int sessionId = getSessionId();
        String customerName = getCustomerName();

        boolean success = bookingService.buyTicket(sessionId, customerName);
        if (success) {
            System.out.println("✅ You Successfully buy a ticket!");
        } else {
            System.out.println("❌ Oh no! You can't buy a ticket.");
        }
    }

    @Override
    public String getDescription() {
        return "buy a ticket";
    }

    private int getSessionId() {
        System.out.print("Enter the session id: ");
        return scanner.nextInt();
    }

    private String getCustomerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }
}
