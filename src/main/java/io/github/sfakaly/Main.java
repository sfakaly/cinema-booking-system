package io.github.sfakaly;

import io.github.sfakaly.commands.UserInteraction;

public class Main {
    public static void main(String[] args) {
        CinemaDatabase db = new CinemaDatabase();
        UserInteraction ui = new UserInteraction();
        BookingService bookingService = new BookingService(db, ui);

        ConsoleUI consoleUI = new ConsoleUI(db, ui, bookingService);
        consoleUI.run();
    }
}
