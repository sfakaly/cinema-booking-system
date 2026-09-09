package io.github.sfakaly;

import java.util.ArrayList;
import java.util.List;

public class CinemaDatabase {
    private List<Movie> movies = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Session findSessionById(int id) {
        return sessions.stream()
                .filter(session -> session.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
