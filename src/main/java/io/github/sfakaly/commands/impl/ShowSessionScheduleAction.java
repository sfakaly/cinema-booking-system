package io.github.sfakaly.commands.impl;

import io.github.sfakaly.CinemaDatabase;
import io.github.sfakaly.models.Session;
import io.github.sfakaly.commands.MenuAction;

public class ShowSessionScheduleAction implements MenuAction {
    private CinemaDatabase db;

    public ShowSessionScheduleAction(CinemaDatabase db) {
        this.db = db;
    }

    @Override
    public void execute() {
        for (Session session: db.getSessions()) {
            System.out.println(session);
        }
    }

    @Override
    public String getDescription() {
        return "Show session time";
    }
}
