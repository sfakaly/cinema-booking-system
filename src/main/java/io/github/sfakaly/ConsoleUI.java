package io.github.sfakaly;

import io.github.sfakaly.commands.MenuAction;
import io.github.sfakaly.commands.UserInteraction;
import io.github.sfakaly.commands.impl.BuyTicketAction;
import io.github.sfakaly.commands.impl.HelpAction;
import io.github.sfakaly.commands.impl.ShowAllPurchasedTicketAction;
import io.github.sfakaly.commands.impl.ShowSessionScheduleAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleUI {
    private final UserInteraction ui;
    private final Map<Integer, MenuAction> commands = new LinkedHashMap<>();
    private boolean isRunning = true;

    public ConsoleUI(CinemaDatabase db, UserInteraction ui, BookingService bookingService) {
        this.ui = ui;
        commands.put(1, new ShowSessionScheduleAction(db));
        commands.put(2, new BuyTicketAction(bookingService, ui));
        commands.put(3, new ShowAllPurchasedTicketAction(db));
        commands.put(4, new HelpAction(commands));
    }

    public void run() {
        System.out.println("Welcome to the Cinema Booking System! (CBS)");
        while (isRunning) {
            int menuNumber = ui.readInt("Enter the menu number (4 for command help)");

            if (menuNumber == 0) {
                isRunning = false;
            }

            handleCommand(menuNumber);
        }
    }

    private void handleCommand(int menuNumber) {
        MenuAction menuAction = commands.get(menuNumber);

        if (menuAction != null) {
            try {
                menuAction.execute();
            } catch (Exception e) {
                ui.printError("Unknown number menu");
            }
        }
    }
}
