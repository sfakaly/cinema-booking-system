package io.github.sfakaly;

public class Session {
    private int id;
    private Movie movie;
    private double ticketPrice;
    private int availableSeats;

    public Session(int id, Movie movie, double ticketPrice, int availableSeats) {
        this.id = id;
        this.movie = movie;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return String.format("Movie: %s | Ticket price: %f | Available seats: %d | Id: %d", movie, ticketPrice, availableSeats, id);
    }
}
