package io.github.sfakaly;

public class Ticket {
    private int id;
    private int sessionId;
    private String customerName;

    public Ticket(int id, int sessionId, String customerName) {
        this.id = id;
        this.sessionId = sessionId;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return String.format("Id: %d | Session id: %d | Customer name: %s", id, sessionId, customerName);
    }
}
