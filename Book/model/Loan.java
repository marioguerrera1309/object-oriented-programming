package org.unict.model;

import java.time.LocalDate;

public class Loan {
    private User user;
    private LocalDate startDate, dueDate;

    public Loan(User user, LocalDate startDate, LocalDate dueDate) {
        this.user = user;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" + "user(name=" + user.getName()
                + ", id=" + user.getId() +
                "), startDate=" + startDate + ", dueDate=" + dueDate + '}';
    }
}
