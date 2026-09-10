package io.github.sfakaly.commands.impl;

import io.github.sfakaly.commands.MenuAction;

import java.awt.*;
import java.util.Map;

public class HelpAction implements MenuAction {
    private final Map<Integer, MenuAction> commands;

    public HelpAction(Map<Integer, MenuAction> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println();
        for (MenuAction action: commands.values()) {
            System.out.printf("%d — %s\n", action.getCode(), action.getDescription());
        }
    }

    public String getDescription() {
        return "Show all menu commands";
    }

    @Override
    public int getCode() {
        return 4;
    }
}
