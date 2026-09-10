package io.github.sfakaly.commands;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    public String readString(String prompt) {
        System.out.printf("> %s:", prompt);
        return scanner.nextLine().trim().toLowerCase();
    }

    public int readInt(String prompt) {
        while (true) {
            try {
                String input = readString(prompt);
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                printError("Error! You can write only numbers.");
            }
        }
    }

    public void printError(String errorPrompt) {
        System.out.println("[!] " + errorPrompt + "\n");
    }

    public void printSuccessMessage(String prompt) {
        System.out.println("[✓] " + prompt + "\n");
    }

    public boolean confirm(String prompt) {
        while (true) {
            String input = readString(prompt);
            switch (input) {
                case "yes" -> {
                    return true;
                }
                case "no" -> {
                    return false;
                }
            }
        }
    }
}
