package io.github.sfakaly;

import io.github.sfakaly.commands.UserInteraction;

public class Main {
    public static void main(String[] args) {
        CinemaDatabase db = new CinemaDatabase();
        BookingService bookingService = new BookingService(db);

        UserInteraction ui = new UserInteraction();

        ConsoleUI consoleUI = new ConsoleUI(db, ui, bookingService);
        consoleUI.run();
    }
}
